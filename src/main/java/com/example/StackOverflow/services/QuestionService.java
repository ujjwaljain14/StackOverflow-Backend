package com.example.StackOverflow.services;

import com.example.StackOverflow.dto.QuestionDto;
import com.example.StackOverflow.models.Question;
import com.example.StackOverflow.models.QuestionStatus;
import com.example.StackOverflow.models.Topic;
import com.example.StackOverflow.models.User;
import com.example.StackOverflow.repositories.QuestionRepository;
import com.example.StackOverflow.repositories.TopicRepository;
import com.example.StackOverflow.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class QuestionService implements CommandLineRunner {

    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;
    private final TopicRepository topicRepository;
    private final FollowService followService;

    public QuestionService(QuestionRepository questionRepository, UserRepository userRepository, TopicRepository topicRepository, FollowService followService) {
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
        this.topicRepository = topicRepository;
        this.followService = followService;
    }

    public Question createNewQuestion(QuestionDto questionDto){
        User user = userRepository.findById(UUID.fromString(questionDto.getUserId()))
                    .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        List<Topic> topics = new ArrayList<>();

        for(String uuid: questionDto.getTopicIds()){
            Topic t = topicRepository.findById(UUID.fromString(uuid))
                        .orElseThrow(() -> new IllegalArgumentException("Invalid topic ID"));
            topics.add(t);
        }

        Question ques = Question.builder()
                        .user(user)
                        .title(questionDto.getTitle())
                        .body(questionDto.getBody())
                        .topics(topics)
                        .questionStatus(QuestionStatus.UNANSWERED)
                        .answers(new ArrayList<>())
                        .build();

        questionRepository.save(ques);

        return ques;
    }

    public List<Question> getQuestionsByStatus(String status){

        QuestionStatus questionStatus = QuestionStatus.valueOf(status.toUpperCase());
        return questionRepository.findAllQuestionsByQuestionStatus(questionStatus);
    }

    public List<Question> getQuestionsByFollowing(String userId){
        List<User> followingList = followService.getFollowings(userId);
        return questionRepository.findAllByUserInOrderByUpdatedAtDesc(followingList);
    }

    public List<Question> searchQuestions(String title, String topicId) {
        System.out.println(title + " " + topicId);
        if(topicId == null && title == null) return new ArrayList<>();

        if(topicId == null){
            return questionRepository.findAllByTitleContaining(title);
        }
        Topic topic = topicRepository.findById(UUID.fromString(topicId))
                .orElseThrow(() -> new IllegalArgumentException("Invalid topic ID"));

        if(title == null){
            return questionRepository.findAllByTopicsContaining(topic);
        }
        return questionRepository.findAllQuestionsByTitleOrTopicsContaining(title,topic);
    }



    @Override
    public void run(String... args) throws Exception {
        System.out.println("***********Question Service*************");
    }


}
