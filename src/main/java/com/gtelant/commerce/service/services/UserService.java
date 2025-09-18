package com.gtelant.commerce.service.services;

import com.gtelant.commerce.service.dtos.UserSegmentResponse;
import com.gtelant.commerce.service.models.Segment;
import com.gtelant.commerce.service.models.User;
import com.gtelant.commerce.service.models.UserSegment;
import com.gtelant.commerce.service.repositories.SegmentRepository;
import com.gtelant.commerce.service.repositories.UserRepository;
import com.gtelant.commerce.service.repositories.UserSegmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

//使用service層和controller溝通
@Service
public class UserService {

    private final UserRepository userRepository;
    private final SegmentRepository segmentRepository;
    private final UserSegmentRepository userSegmentRepository;

    @Autowired
    public UserService(UserRepository userRepository, SegmentRepository segmentRepository, UserSegmentRepository userSegmentRepository){
        this.userRepository = userRepository;
        this.segmentRepository = segmentRepository;
        this.userSegmentRepository = userSegmentRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Page<User> getAllUsers(PageRequest pageRequest){
        return userRepository.findAll(pageRequest);
    }

    public User getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(int id, User user){
        if(userRepository.existsById(id)){
            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }

    public void assignSegmentToUser(int id, int segmentId){
        Optional<Segment> segment = segmentRepository.findById(segmentId);
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()&& segment.isPresent()){
            UserSegment userSegment = new UserSegment();
            userSegment.setSegment(segment.get());
            userSegment.setUser(user.get());
            userSegmentRepository.save(userSegment);
        }
    }

//    public List<UserSegment> assignSegmentToUser(int id, int segmentId) {
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        Segment segment = segmentRepository.findById(segmentId)
//                .orElseThrow(() -> new RuntimeException("Segment not found"));
//
//        // 檢查是否已存在這筆關聯
//        Optional<UserSegment> existing = userSegmentRepository.findByUserAndSegment(user, segment);
//        if (existing.isPresent()) {
//            return user.getUserSegments(); // 已存在就直接回傳
//        }
//
//        // 建立新的關聯
//        UserSegment userSegment = new UserSegment();
//        userSegment.setUser(user);
//        userSegment.setSegment(segment);
//        userSegment.setCreatedAt(LocalDateTime.now());
//
//        userSegmentRepository.save(userSegment);
//
//        // 更新 user 的 segment 清單（如果你有 mappedBy）
//        user.getUserSegments().add(userSegment);
//
//        return user.getUserSegments();
//    }

}
