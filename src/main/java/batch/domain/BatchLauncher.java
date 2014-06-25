package batch.domain;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BatchLauncher {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext-batch.xml");
		SimpleJobLauncher launcher = (SimpleJobLauncher) context.getBean("jobLauncher");
		launcher.setJobRepository((JobRepository) context.getBean("jobRepository"));
		Job job = (Job) context.getBean("testJob");

		try {
			/* 运行Job */
			JobExecution result = launcher.run(job, new JobParameters());
			/* 处理结束，控制台打印处理结果 */
			System.out.println(result.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
