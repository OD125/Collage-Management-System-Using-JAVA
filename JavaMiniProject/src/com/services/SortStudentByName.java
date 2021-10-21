package com.services;

import java.util.Comparator;

import com.bean.StudentBn;

public class SortStudentByName implements Comparator<StudentBn>{

	@Override
	public int compare(StudentBn student1, StudentBn student2) {
		return student1.getName().compareTo(student2.getName());
	}

}
