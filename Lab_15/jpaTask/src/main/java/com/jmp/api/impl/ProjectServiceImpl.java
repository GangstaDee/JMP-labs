package com.jmp.api.impl;

import com.jmp.api.ProjectService;
import com.jmp.entity.Project;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

@Service("projectService")
@Repository
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @PersistenceContext(type = PersistenceContextType.EXTENDED) //dirty hack
    private EntityManager entityManager;

    public Project save(Project project)  {

        if (project.getId() == null) {
            entityManager.persist(project);
        } else {
            project = entityManager.merge(project);
        }
        return project;
    }

    public Project find(int projectID) {
        return entityManager.find(Project.class, projectID);
    }

    public int delete(int projectID) {

        Query query = entityManager.createQuery(
                "DELETE FROM Project p WHERE p.id = :param");
        int removed = query.setParameter("param", projectID).executeUpdate();
        return removed;
    }
}
