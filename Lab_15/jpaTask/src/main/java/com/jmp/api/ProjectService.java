package com.jmp.api;

import com.jmp.entity.Project;

public interface ProjectService {

    Project save(Project project);

    Project read(int projectID, boolean eager);

    int delete(int projectID);
}

