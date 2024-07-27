package com.example.StackOverflow.services;

import com.example.StackOverflow.dto.VoteDto;
import com.example.StackOverflow.models.*;
import com.example.StackOverflow.repositories.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VoteService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final QuestionVoteRepository questionVoteRepository;
    private final AnswerVoteRepository answerVoteRepository;
    private final CommentVoteRepository commentVoteRepository;

    public VoteService(QuestionRepository questionRepository, AnswerRepository answerRepository, CommentRepository commentRepository, UserRepository userRepository, QuestionVoteRepository questionVoteRepository, AnswerVoteRepository answerVoteRepository, CommentVoteRepository commentVoteRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.questionVoteRepository = questionVoteRepository;
        this.answerVoteRepository = answerVoteRepository;
        this.commentVoteRepository = commentVoteRepository;
    }

    public QuestionVote voteQuestion(String questionId, VoteDto voteDto){
        User user = userRepository.findById(UUID.fromString(voteDto.getUserId()))
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        Question question = questionRepository.findById(UUID.fromString(questionId))
                .orElseThrow(() -> new IllegalArgumentException("Invalid Question ID"));




        Optional<QuestionVote> existingVote = questionVoteRepository.findByUserAndQuestion(user, question);
        QuestionVote vote;
        if (existingVote.isPresent()) {
            vote = existingVote.get();
            if (!vote.getVoteType().equals(VoteType.valueOf(voteDto.getVoteType().toUpperCase()))) {
                vote.setVoteType(VoteType.valueOf(voteDto.getVoteType().toUpperCase()));
            } else {
                questionVoteRepository.delete(vote);
                return null;
            }
        } else {
            // Create a new vote if the user hasn't voted yet
            vote = QuestionVote.builder()
                    .voteType(VoteType.valueOf(voteDto.getVoteType().toUpperCase()))
                    .user(user)
                    .question(question)
                    .build();
        }

        questionVoteRepository.save(vote);
        return vote;
    }


    public AnswerVote voteAnswer(String answerId, VoteDto voteDto){
        User user = userRepository.findById(UUID.fromString(voteDto.getUserId()))
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        Answer answer = answerRepository.findById(UUID.fromString(answerId))
                .orElseThrow(() -> new IllegalArgumentException("Invalid Answer ID"));




        Optional<AnswerVote> existingVote = answerVoteRepository.findByUserAndAnswer(user, answer);
        AnswerVote vote;
        if (existingVote.isPresent()) {
            vote = existingVote.get();
            if (!vote.getVoteType().equals(VoteType.valueOf(voteDto.getVoteType().toUpperCase()))) {
                vote.setVoteType(VoteType.valueOf(voteDto.getVoteType().toUpperCase()));
            } else {
                answerVoteRepository.delete(vote);
                return null;
            }
        } else {
            // Create a new vote if the user hasn't voted yet
            vote = AnswerVote.builder()
                    .voteType(VoteType.valueOf(voteDto.getVoteType().toUpperCase()))
                    .user(user)
                    .answer(answer)
                    .build();
        }

        answerVoteRepository.save(vote);
        return vote;
    }


    public CommentVote voteComment(String commentId, VoteDto voteDto){
        User user = userRepository.findById(UUID.fromString(voteDto.getUserId()))
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        Comment comment = commentRepository.findById(UUID.fromString(commentId))
                .orElseThrow(() -> new IllegalArgumentException("Invalid Comment ID"));




        Optional<CommentVote> existingVote = commentVoteRepository.findByUserAndComment(user, comment);
        CommentVote vote;
        if (existingVote.isPresent()) {
            vote = existingVote.get();
            if (!vote.getVoteType().equals(VoteType.valueOf(voteDto.getVoteType().toUpperCase()))) {
                vote.setVoteType(VoteType.valueOf(voteDto.getVoteType().toUpperCase()));
            } else {
                commentVoteRepository.delete(vote);
                return null;
            }
        } else {
            // Create a new vote if the user hasn't voted yet
            vote = CommentVote.builder()
                    .voteType(VoteType.valueOf(voteDto.getVoteType().toUpperCase()))
                    .user(user)
                    .comment(comment)
                    .build();
        }

        commentVoteRepository.save(vote);
        return vote;
    }

}
