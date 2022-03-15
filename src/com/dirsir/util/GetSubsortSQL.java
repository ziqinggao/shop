package com.dirsir.util;

import java.util.List;

public class GetSubsortSQL {
	public static String getsubsortSql(List<Integer> list,int commodityId) {
		String[] tableName=new String[list.size()];
		String a="";
		String sql="";
		for(int i=0;i<list.size()-1;i++) {
			a+="a";
			tableName[i]=a;
			sql+="(select subsort_name from commodity_subsort where subsort_state=1 and sort_id="+list.get(i)+") "+a+",";
		}
		a+="a";
		tableName[list.size()-1]=a;
		sql+="(select subsort_name from commodity_subsort where subsort_state=1 and sort_id="+list.get(list.size()-1)+") "+tableName[list.size()-1];
		String sql1="select "+commodityId+" as commodity_id ,concat(";
		for (int i = 0; i < tableName.length-1; i++) {
			sql1+=tableName[i]+".subsort_name,";
		}
		sql1+=tableName[tableName.length-1]+".subsort_name)subsort from";
		
		return sql1+sql;
	}
}
