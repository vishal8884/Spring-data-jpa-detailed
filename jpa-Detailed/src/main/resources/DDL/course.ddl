CREATE TABLE `course` (
  `course_id` bigint NOT NULL,
  `course_title` varchar(255) DEFAULT NULL,
  `credit` int DEFAULT NULL,
  `teacher_id` bigint DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `FKsybhlxoejr4j3teomm5u2bx1n` (`teacher_id`),
  CONSTRAINT `FKsybhlxoejr4j3teomm5u2bx1n` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

