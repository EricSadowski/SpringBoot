package com.video.springVideo;

import com.video.springVideo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringVideoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringVideoApplication.class, args);
	}


}

@GetMapping
public List<Student> hello(){
	return List.of(
			new Student(
					1L,
							"Mariam",
							"eee@gmnail.com"

			)
	);

}


//					id: 1L,
//							"Mariam",
//							"eee@gmnail.com",
//							LocalDate.of(year:2000 Month.JANUARY, dayOfMonth:5),
