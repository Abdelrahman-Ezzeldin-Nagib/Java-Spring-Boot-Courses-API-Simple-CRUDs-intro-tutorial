package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	
	private List<Topic> topics_list = new ArrayList<>( Arrays.asList(
			new Topic("Spring Boot ", "spring boot course", "this is a course of spring boot"),
			new Topic("Python Datascience", "python datascience", "this is a course of datascience with python"),
			new Topic("Python DL", "python Deep Learning", "this is a course of DL with python"),
			new Topic("Java", "Java Spring Boot", "this is a course of Java and Spring Boot")
			));

	public List<Topic> getAllTopics(){
		return topics_list;
	}
	public Topic getTopic(String id) {
		return topics_list.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	public void addTopic(Topic topic) {
		topics_list.add(topic);
	}
	
	public void updateTopic(String id, Topic topic) {
		for (int i = 0; i < topics_list.size(); i++) {
			Topic t = topics_list.get(i);
			if(t.getId().equals(id)){
				topics_list.set(i, topic);
				return;
			}
		}
	}
	
	public void deleteTopic(String id) {
		topics_list.removeIf(t -> t.getId().equals(id));
	}
	
}
