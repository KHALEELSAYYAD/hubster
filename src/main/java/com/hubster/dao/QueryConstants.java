package com.hubster.dao;

public interface QueryConstants {


	public String todo_query="SELECT  chid,timestamp,ip,formID,redirect_to,csuitegoal,csuitenotes,stratcat,stratimportance,challenge," + 
			"chnotes,cheid,checompany,chediv,cheregion,chedept,chefunc,chearea,chmeetdate,chmeetlog,cheKP," + 
			"chtopics,chdiscussion,chopimpact,choprestimpact,svimpactch,svalch,svvalbpch,idimpactch,idvalch," + 
			"idvalbpch,idvvalbpch,imimpactch,imvalch,imvalbpch,imvvalbpch,rvimpactch,rvvalch,rvvalbpch,rvvvalbpch," + 
			"chresolveDate,cheassign,chexecdirective,chexemgr,chrequester,chstatus,chstatusdate,bestpract,resource," + 
			"priority,comments,x,y,chentity,svalchc,idvalchc,imvalchc,rvvalchc,initiative,goals,followup,follownote,vcumscore," + 
			"vtcumscore,staffe_id,mgr_id,svalstrength,svalweak,svalthreat,svalopport,idvalstrength,idvalweak," + 
			"idvalthreat,idvalopport,imvalstrength,imvalweak," + 
			"imvalthreat,imvalopport,rvalstrength,rvalweak,rvalthreat," + 
			"rvalopport,vc from challenge  where cheassign= ?";
	
}
