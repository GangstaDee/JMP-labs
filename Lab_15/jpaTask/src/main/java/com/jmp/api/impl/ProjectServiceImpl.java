package com.jmp.api.impl;

import com.jmp.api.ProjectService;
import com.jmp.dao.ProjectDAO;
import com.jmp.entity.Project;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("projectService")
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private ProjectDAO projectDAO;

    public Project save(Project project)  {
        return projectDAO.save(project);
    }

    public Project read(int projectID, boolean eager) {
        if(eager) {
            Project project = projectDAO.readFullDetails(projectID);
        }
        return projectDAO.read(projectID);
    }

    public int delete(int projectID) {
        return projectDAO.delete(projectID);
    }
}
