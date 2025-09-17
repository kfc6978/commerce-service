package com.gtelant.commerce.service.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_segments",  uniqueConstraints = @UniqueConstraint(name = "uni_user_segment",
        columnNames = {"user_id", "segment_id"})
)
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserSegment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_segment_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JsonBackReference
    @JoinColumn(name = "segment_id")
    private Segment segment;

    //@CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}

// 如欲刪除 segment_id=2
// 1. delete from user_segments where segment_id=2
// 2. delete from segments where id=2




/* 複合主鍵
@Entity
@Table(name = "user_segments")
@IdClass(UserSegment.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSegment {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "segment_id")
    private Segment segment;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
*/
