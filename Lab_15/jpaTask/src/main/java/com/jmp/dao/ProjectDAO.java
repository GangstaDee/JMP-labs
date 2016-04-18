package com.jmp.dao;

import com.jmp.entity.Project;

public interface ProjectDAO {

    Project save(Project project);

    Project read(int projectID);

    Project readFullDetails(int projectID);

    int delete(int projectID);
}
