package com.ourownjava.atg.repository;

import atg.adapter.gsa.GSARepository;
import atg.repository.Query;
import atg.repository.QueryBuilder;
import atg.repository.QueryExpression;
import atg.repository.RepositoryException;
import atg.repository.RepositoryItem;
import atg.repository.RepositoryView;

/**
 * 
 * @author ourownjava.com
 */

public class EmployeeTool {

	private GSARepository gsaRepository;

	public void setGsaRepository(final GSARepository gsaRepository) {
		this.gsaRepository = gsaRepository;
	}

	public RepositoryItem[] findSuggestions(final String name)
			throws RepositoryException {

		final RepositoryView employeeView = gsaRepository.getView("EMPLOYEE");
		final QueryBuilder queryBuilder = employeeView.getQueryBuilder();
		final QueryExpression propertyExpression = queryBuilder
				.createPropertyQueryExpression("name");
		final QueryExpression valueExpression = queryBuilder
				.createConstantQueryExpression(name);
		final Query accountQuery = queryBuilder.createPatternMatchQuery(
				propertyExpression, valueExpression, QueryBuilder.CONTAINS);
		final RepositoryItem[] repositoryItems = employeeView
				.executeQuery(accountQuery);
		return repositoryItems;

	}
}