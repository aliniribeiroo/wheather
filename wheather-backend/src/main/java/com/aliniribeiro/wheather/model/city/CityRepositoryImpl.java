package com.aliniribeiro.wheather.model.city;

import com.aliniribeiro.wheather.model.common.PageRequest;
import com.aliniribeiro.wheather.model.common.PageResult;
import com.aliniribeiro.wheather.model.common.RepositoryBaseImpl;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.util.StringUtils;

public class CityRepositoryImpl extends RepositoryBaseImpl implements CityCustom {

    @Override
    public PageResult searchCities(String q, Long page, Long size) {
        QCityEntity city = QCityEntity.cityEntity;

        JPAQuery<CityEntity> query = select(city).from(city);
        if (!StringUtils.isEmpty(q)) {
            String[] terms = q.replaceAll("\\s+", " ").trim().split("\\s");
            BooleanExpression predicate = null;
            for (String t : terms) {
                BooleanExpression namePredicate = city.name.containsIgnoreCase(t);
                predicate = predicate == null ? namePredicate : predicate.and(namePredicate);
            }
            if (predicate != null) {
                query.where(predicate);
            }
        }

        PageRequest pageRequest = new PageRequest(page, size);
        return getPagedQuery(query, pageRequest);
    }
}
