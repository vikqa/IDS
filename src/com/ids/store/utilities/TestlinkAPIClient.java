//package  com.deftsoft.demo.utilities;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.Hashtable;
//import java.util.Map;
//
//import org.apache.xmlrpc.XmlRpcException;
//import org.apache.xmlrpc.client.XmlRpcClient;
//import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
//
//import testlink.api.java.client.TestLinkAPIClient;
//import testlink.api.java.client.TestLinkAPIException;
//
//
//public class TestlinkAPIClient {
//	
//	@SuppressWarnings("rawtypes")
//	public static void createTestLinkBuild(String testLinkURL, String devKey, String project, String testPlan,
//			String build, String des) {
//		try {
//			XmlRpcClient rpcClient;
//			XmlRpcClientConfigImpl config;
//			config = new XmlRpcClientConfigImpl();
//			config.setServerURL(new URL(testLinkURL));
//			rpcClient = new XmlRpcClient();
//			rpcClient.setConfig(config);
//			ArrayList<Object> params = new ArrayList<Object>();
//			Hashtable<String, Object> executionData = new Hashtable<String, Object>();
//			executionData.put("devKey", devKey);
//			params.add(executionData);
//			Object[] result = (Object[]) rpcClient.execute("tl.getProjects", params);
//			int idProject = -1;
//			for (int i = 0; i < result.length; i++) {
//				Map item = (Map) result[i];				
//				if (item.get("name").equals(project)) {
//					idProject = Integer.parseInt((String) item.get("id"));
//					break;
//				}
//			}
//			int idTestPlan = -1;
//			if (idProject != -1) {
//				params = new ArrayList<Object>();
//				executionData = new Hashtable<String, Object>();
//				executionData.put("devKey", devKey);
//				executionData.put("testprojectid", idProject);
//				params.add(executionData);
//				result = (Object[]) rpcClient.execute("tl.getProjectTestPlans", params);
//				for (int i = 0; i < result.length; i++) {
//					Map item = (Map) result[i];					
//					if (item.get("name").equals(testPlan)) {
//						idTestPlan = Integer.parseInt((String) item.get("id"));
//						break;
//					}
//				}
//			}
//			if (idTestPlan != -1) {
//				params = new ArrayList<Object>();
//				executionData = new Hashtable<String, Object>();
//				executionData.put("devKey", devKey);
//				executionData.put("testplanid", idTestPlan);
//				executionData.put("buildname", build);
//				executionData.put("buildnotes", des);
//				params.add(executionData);
//				result = (Object[]) rpcClient.execute("tl.createBuild", params);
//			}
//
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (XmlRpcException e) {
//			e.printStackTrace();
//		}
//
//	}
//	
//	public static void reportResult(String testLinkURL, String devKey, String project, String testPlan,
//			String build, String testCase, String notes, String result){
//		try {
//			TestLinkAPIClient api = new TestLinkAPIClient(devKey, testLinkURL);
//			api.reportTestCaseResult(project, testPlan, testCase, build, notes, result);
//		} catch (TestLinkAPIException e) {			
//			e.printStackTrace();
//		}
//		
//		
//	}
//}
