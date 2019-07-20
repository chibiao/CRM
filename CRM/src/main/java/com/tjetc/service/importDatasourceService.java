package com.tjetc.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tjetc.mySqlUtil.MySqlUtil;

@Component
public class importDatasourceService {
	@Scheduled(cron="0 0/10 * * * ? ")   //每10分钟执行一次 
	public void autoLoad(){	
		MySqlUtil.doBackup();		
	}
	public boolean autoImport(String fileName){
		return new MySqlUtil().restore(fileName);
	}
}
