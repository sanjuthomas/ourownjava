package com.ourownjava.search.endeca;

import com.endeca.navigation.DimValIdList;
import com.endeca.navigation.ENEConnection;
import com.endeca.navigation.ENEQuery;
import com.endeca.navigation.ENEQueryException;
import com.endeca.navigation.ENEQueryResults;
import com.endeca.navigation.ERec;
import com.endeca.navigation.HttpENEConnection;
 
/**
 * 
 * @author ourownjava.com
 * 
 */
 
public class NavigationSearchClient {
 
    private static final String MDEX_HOST = "localhost";
 
    private static final Integer MDEX_PORT = 15000;
 
    /**
     * @param args
     * @throws ENEQueryException
     */
    public static void main(final String[] args) throws ENEQueryException {
 
        final ENEQueryResults results = createConnection().query(createNavigationQuery("0"));
        final StringBuilder builder = new StringBuilder();
        builder.append("Found ");
        builder.append(results.getNavigation().getERecs().size());
        builder.append(" results.\n");
        for (Object result : results.getNavigation().getERecs()) {
            final ERec eRec = (ERec) result;
            for (Object key : eRec.getProperties().keySet()) {
                builder.append(key);
                builder.append(" >> ");
                builder.append(eRec.getProperties().get(key));
            }
        }
        System.out.println(builder.toString());
    }
 
    private static ENEQuery createNavigationQuery(final String nValue) {
        final ENEQuery query = new ENEQuery();
        final DimValIdList dimValIdList = new DimValIdList(nValue);
        query.setNavDescriptors(dimValIdList);
        query.setNavNumERecs(100);
        return query;
    }
 
    /**
     * @return
     */
    private static ENEConnection createConnection() {
        return new HttpENEConnection(MDEX_HOST, MDEX_PORT);
    }
 
}