package com.jmp.dao.impl;

import com.jmp.dao.ProjectDAO;
import com.jmp.entity.Project;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Project save(Project project) {

        if (project.getId() == null) {
            entityManager.persist(project);
        } else {
            project = this.entityManager.merge(project);
        }
        return project;
    }

    @Override
    public Project read(int projectID) {
        return entityManager.find(Project.class, projectID);
    }

    @Override
    public Project readFullDetails(int projectID) {

        try {
            Query q = this.entityManager.createQuery("SELECT project FROM Project project LEFT JOIN FETCH project.employees emp WHERE project.id = :id");
            q.setParameter("id", projectID);
            return (Project) q.getSingleResult();

        }  catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public int delete(int projectID) {
        Query query = this.entityManager.createQuery(
                "DELETE FROM Project p WHERE p.id = :param");
        int removed = query.setParameter("param", projectID).executeUpdate();
        return removed;
    }
}
