package com.jmp.api;

import com.jmp.entity.Project;

public interface ProjectService {

    Project save(Project project);

    Project find(int projectID);

    int delete(int projectID);
}

