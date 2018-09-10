package fi.yasir.messaging.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import fi.yasir.messaging.model.Message;

@RunWith(SpringRunner.class)
public class MessageRepositoryTest {

	@TestConfiguration
	static class FizzBuzzServiceImplTestContextConfiguration {

		@Bean
		public MessageRepository initMessageRepository() {
			return new MessageRepository();
		}
	}

	@Autowired
	private MessageRepository messageRepository;

	@Test
	public void testInitialisation() {
		assertThat(messageRepository).isNotNull();
	}

	@Test
	public void testAddMessage() {
		Message message = new Message();
		message.setFromUserName("user1");
		message.setToUserName("user2");
		message.setMessage("hello");
		List<Message> messages = messageRepository.addMessage(message);
		assertThat(messages).contains(message);
	}
	
	@Test
	public void testSingleMessageForBothUser() {
		Message message = new Message();
		message.setFromUserName("A");
		message.setToUserName("B");
		message.setMessage("hello");
		assertThat(messageRepository.addMessage(message)).contains(message);
		assertThat(messageRepository.getMessages(message.getToUserName())).hasSize(1);
		Message message1 = new Message();
		message1.setFromUserName("B");
		message1.setToUserName("A");
		message1.setMessage("hello");
		assertThat(messageRepository.addMessage(message1)).contains(message1);
		assertThat(messageRepository.getMessages(message1.getToUserName())).hasSize(1);
		
	}

}
