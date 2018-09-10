package fi.yasir.messaging.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fi.yasir.messaging.model.Message;

public class MessageRepository {

	private final Map<String, List<Message>> messages = new HashMap<>();

	public List<Message> addMessage(Message message) {
		String toUserName = message.getToUserName();
		List<Message> userMessages = getMessages(toUserName);
		userMessages.add(message);
		return updateUserMessages(toUserName, userMessages);
	}

	public List<Message> getMessages(String toUserName) {
		if (!messages.containsKey(toUserName)) {
			messages.put(toUserName, new ArrayList<>());
		}
		return messages.get(toUserName);
	}

	private List<Message> updateUserMessages(String toUserName, List<Message> userMessages) {
		messages.replace(toUserName, userMessages);
		return userMessages;
	}

}
