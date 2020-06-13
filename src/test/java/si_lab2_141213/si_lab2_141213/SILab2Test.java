package si_lab2_141213.si_lab2_141213;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SILab2Test {
	private SILab2 siLab2;

	public SILab2Test() {
		this.siLab2 = new SILab2();
	}

	private boolean testFunction(User user, ArrayList<String> userList) {
		boolean isValid = this.siLab2.function(user, userList);
		if (isValid) {
			userList.add(user.username);
		}
		return isValid;
	}

	@Test
	void everyPathCriterium() {
		ArrayList<String> UserList = new ArrayList<String>();
		RuntimeException err;
		boolean isValid;

		// 1,2
		err = assertThrows(RuntimeException.class, () -> this.testFunction(null, UserList),
				"Should fail with a null User");
		assertEquals("The user argument is not initialized!", err.getMessage(),
				"Should have the expected exception message");

		// 1,3,4
		err = assertThrows(RuntimeException.class,
				() -> this.testFunction(new User(null, "Test123!", "andrej@emailcom"), UserList),
				"Should fail with a null Username");
		assertEquals("User already exists!", err.getMessage(), "Should have the expected exception message");

		// 1,3,5,6
		isValid = this.testFunction(new User("Andrej", "Test123!", null), UserList);
		assertFalse(isValid, "Should return false with null email");

		// 1,3,5,7,8,9,11,13,14
		isValid = this.testFunction(new User("Andrej", "Test123!", "invalidEmail"), UserList);
		assertFalse(isValid, "Should return false with an invalid email with missing '@' and '.' characters");

		// 1,3,5,7,8,9,11,13,14
		isValid = this.testFunction(new User("Andrej", "Test123!", "invalidEmail.si"), UserList);
		assertFalse(isValid, "Should return false with an invalid email with missing '@' character");

		// 1,3,5,7,8,9,10,11,13,14
		isValid = this.testFunction(new User("Andrej", "Test123!", "invalidEmail@test"), UserList);
		assertFalse(isValid, "Should return false with an invalid email with missing '.' character");

		// 1,3,5,7,8,9,10,11,12,13,15
		isValid = this.testFunction(new User("Andrej", "Test123!", "invalidEmail@test.si"), UserList);
		assertTrue(isValid, "Should return true with a valid User");

		// 1,3,4
		err = assertThrows(RuntimeException.class,
				() -> this.testFunction(new User("Andrej", "NewPassword123!", "different@email.com"), UserList),
				"Should fail with a used Username");
		assertEquals("User already exists!", err.getMessage(), "Should have the expected exception message");

		System.out.println("Every Path Criterium Testing Done");
	}

	@Test
	void multipleConditionCriterium() {
		ArrayList<String> userList = new ArrayList<String>();
		RuntimeException err;
		boolean isValid;

		// 3 - user.getUsername() == null || allUsers.contains(user.getUsername())
		// 1,3,4 - 3:TX
		err = assertThrows(RuntimeException.class,
				() -> this.testFunction(new User(null, "Test123!", "andrej@emailcom"), userList));
		assertEquals("User already exists!", err.getMessage(), "Should have the expected exception message");

		// 1,3,4 - 3:FT
		this.testFunction(new User("Andrej", "Test123!", "andrej@email.com"), userList);
		err = assertThrows(RuntimeException.class,
				() -> this.testFunction(new User("Andrej", "Password123!", "andrej-new@email.com"), userList),
				"Should fail with a used Username");
		assertEquals("User already exists!", err.getMessage(), "Should have the expected exception message");

		// 1,3,5,7,8,9,10,11,12,13,15 - 3:FF
		isValid = this.testFunction(new User("Pero", "Pero123!", "pero@email.com"), userList);
		assertTrue(isValid, "Should return true with a valid User");

		// 11 - atChar && user.getEmail().charAt(i) == '.'
		// 1,3,5,7,8,9,11,13,14 - 11:FX
		isValid = this.testFunction(new User("Antonio", "Antonio123!", "Antonioemail.com"), userList);
		assertFalse(isValid, "Should return false with an invalid email with missing '@' character");

		// 1,3,5,7,8,9,10,11,13,14 - 11:TF
		isValid = this.testFunction(new User("Antonio", "Antonio123!", "Antonio@emailcom"), userList);
		assertFalse(isValid, "Should return false with an invalid email with missing '.' character");

		// 1,3,5,7,8,9,10,11,12,13,15 - 11:TT
		isValid = this.testFunction(new User("Antonio", "Antonio123!", "Antonio@email.com"), userList);
		assertTrue(isValid, "Should return true with a valid User");

		// 13 - !atChar || !dotChar
		// 1,3,5,7,8,9,11,13,14 - 13:TX
		isValid = this.testFunction(new User("Vlado", "Vlado123!", "vladoemail"), userList);
		assertFalse(isValid, "Should return false with an invalid email with missing '@' character");

		// 1,3,5,7,8,9,10,11,13,14 - 13:FT
		isValid = this.testFunction(new User("Vlado", "Vlado123!", "vlado@email"), userList);
		assertFalse(isValid, "Should return false with an invalid email with missing '.' character");

		// 1,3,5,7,8,9,10,11,12,13,15 - 13:FF
		isValid = this.testFunction(new User("Vlado", "Vlado123!", "vlado@email.io"), userList);
		assertTrue(isValid, "Should return true with a valid User");

		System.out.println("Multiple Condition Criterium Done");
	}

}
