package com.example.postgres.springbootpostgresdocker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.CountDownLatch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.postgres.springbootpostgresdocker.Model.Employee;
import com.example.postgres.springbootpostgresdocker.services.TransferServiceImpl;

@SpringBootTest
class SpringbootPostgresDockerApplicationTests {

	//private final Logger LOGGER = LoggerFactory.getLogger(SpringbootPostgresDockerApplicationTests.class);


	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private TransferServiceImpl transferServiceImpl;

	@Test
	void contextLoads() {
	}

	@Test
	public void testParallelExecution()
        throws InterruptedException {
    
			contextLoads();

			Employee alice = new Employee();
			alice.setEmail("Alice-123");
			alice.setSalary(10D);
			employeeRepository.save(alice);

			Employee bob = new Employee();
			bob.setEmail("Bob-456");
			bob.setSalary(0D);
			employeeRepository.save(bob);
			
			double d = employeeRepository.getSalary("Alice-123");

			assertEquals(10D, d);
			assertEquals(0D, employeeRepository.getSalary("Bob-456"));
		
			CountDownLatch startLatch = new CountDownLatch(1);
			int threadCount= 8;
			CountDownLatch endLatch = new CountDownLatch(threadCount);
		
			for (int i = 0; i < threadCount; i++) {
				new Thread(() -> {
					try {
						startLatch.await();
		
						transferServiceImpl.transfer(
							"Alice-123", "Bob-456", 5L
						);
					} catch (Exception e) {
						//logger.error("Transfer failed", e);
						e.printStackTrace();
					} finally {
						endLatch.countDown();
					}
				}).start();
			}
			startLatch.countDown();
			endLatch.await();
			
//			LOGGER.info("Alice's balance {}"+ employeeRepository.getSalary("Alice-123"));
			//LOGGER.info("Bob's balance {}"+ employeeRepository.getSalary("Bob-456"));
}
}

