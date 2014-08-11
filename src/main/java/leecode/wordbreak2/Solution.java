package leecode.wordbreak2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/*
 *  Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"]. 
 */
public class Solution {

	   public List<String> wordBreak2(String s, Set<String> dict) {
	        List<String> result = new ArrayList<>();
	        if (s == null || dict.size() == 0) return result;
	        boolean[] match = new boolean[s.length()];
	        for (int i = 0; i < s.length();i++) {
	            if (dict.contains(s.substring(0, i+1))) {
	                match[i] = true;
	            } else {
	                for (int j = 0; j < i; j++) {
	                    match[i] = match[j]
	                              && dict.contains(s.substring(j+1,i+1));
	                    if (match[i]) {
	                        break;
	                    }
	                }
	            }
	        }
	        if (match[s.length()-1]) {
	            String input = "";
	            findMatches(match, s, 0, input, dict, result);
	        }
	        return result;
	    }
	    
	    private void findMatches(boolean[] match, String s, int start, String input, Set<String> dict, List<String> result) {
	        if (start == s.length()) {
	            result.add(input);
	            return;
	        }
	        
	        for (int i = start; i < s.length();i++) {
	            if (match[i]) {
	                String part = s.substring(start,i+1);
	                if (dict.contains(part)) {
	                	String nextInput = null;
	                    if (input.equals("")) {
	                    	nextInput = part;
	                    } else {
	                    	nextInput = input + " " + part;
	                    }
	                    findMatches(match, s, i+1, nextInput, dict, result);
	                }
	                
	            }
	        }
	    }
	
	
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<String > result=new ArrayList<String>();
        LinkedList<String> segment=new LinkedList<String>();
        boolean [][] table=new boolean[s.length()][s.length()];
        wordBreak(table, s, dict);//this is initial the table
        if(!table[0][s.length()-1]){
            return result;
        }
        recurseAdd(0,s,result, segment, table, dict);
        return result;
    }

    public void recurseAdd(int start,String input,ArrayList<String> result, LinkedList<String> forNow,boolean table[][],Set<String> dict){
        if(start==input.length()){
            String newOne="";
            for(int i=forNow.size()-1;i>=0;i--){
                newOne+=forNow.get(i)+" ";
            }
            result.add(newOne.trim());
            return;
        }
        for(int i=1+start;i<=input.length();i++){
            if(dict.contains(input.substring(start,i))){//valid
                if(i<input.length()){
                    if(table[i][input.length()-1]){
                        forNow.push(input.substring(start,i)); //push shi segment into stack;
                        recurseAdd(i, input, result, forNow, table, dict);
                        forNow.pop();
                    }
                }
                else{
                    forNow.push(input.substring(start,i)); //push shi segment into stack;
                    recurseAdd(i, input, result, forNow, table, dict);
                    forNow.pop();
                }

            }
        }

    }

    public void wordBreak(boolean [][] dp, String s, Set<String> dict) { //fill the table to judge any substring if it could be broke or not
        // Note: The Solution object is instantiated only once and is reused by each test case.
        for (int i = 0; i < s.length(); i++) 
            dp[i][i]=dict.contains(s.substring(i,i+1));
        for(int i=1;i<s.length();i++){
            for(int j=0;j<s.length()-i;j++){
                //boolean[j][j+i]
                if(dict.contains(s.substring(j,j+i+1)))
                    dp[j][j+i]=true;
                else{
                    for(int k=j;k<j+i;k++){
                        if(dp[j][k]&&dp[k+1][j+i]){
                            dp[j][j+i]=true;
                            break;
                        }
                    }
                }
            }
        }
    }
	
	
	public static void main(String[] args) {
/*		String s ="fkjjlbhkbbefinemajmoebhjbkojmcaehiibankkomghncojbjgedebjfdocjhclmbalebladkcaidacaiiokemdmaabjalmbgggjjfjfedegmnkidceogjdgncmlhodkcmjkfolgfnaklkjbocjhhakgmigkcmilbikbhjcgz";
		String[] strings = new String[] {"gaggkdeo","igkcmil","mfljaieijcjk","nddenji","ihkao","k","halnhbcmabjb","aeb","hmamkhmlfce","mnkjgjjodida","gm","hancobi","g","hmoafjnono","meanolmbloog","nochomliagledo","ahdimafaacc","necn","goicmonlkil","jfigiglloi","jjfjfede","akgjlbgjldec","oooij","dk","elbofj","mmddfkfig","kaklf","bcbeenfeee","ajkooijb","oaanehdai","e","omk","mfmed","iheidmbjeinfebk","bikbhjcg","eh","hmbneijnk","cccganlndjo","igfmdoiihc","edoncgeohal","i","glie","ncojbjg","gnmifoifaec","ncogocd","kgogljaidon","dkghjha","mf","fmoimobjf","incmj","ihiehafnmilce","hji","daoklglc","obbomj","fh","f","mnmbhk","jaj","ikbdlhfhk","lihmboinijkkka","cda","boimoc","iohgjocn","gaof","lld","jhhak","jhjekma","jedihdccoojide","anibenolmjmbf","ofhaicalhmdcnjd","c","egonomcienfh","ml","lgekjonkeao","ddhahngil","gfmcb","oiikakdhl","iab","jehicc","jmocmaiokn","eflmhnglhejd","ahii","dmo","dfdgfnmldhaooae","nohgoc","jjlmggdbhno","odkimohjodbh","dmhkkgjcjhiid","fcdgbjgbbm","mhoomlad","nbofdoofom","cencoc","aefehagm","nnio","jjiigmc","cgel","ela","hhd","jkkddacaam","b","mo","md","damiock","ebeao","mlffgmgbloc","abgmmnmiijglm","ibjdnckgfonia","nn","mnc","hijgoeco","jkgaghmhlnehc","ieadnfjcoi","kmjfnjhlabcihe","gobkj","cmajffc","hhbmckl","fgmghbh","ehclhidfbfb","nibjmglgmglhf","hnblghaejege","nkkomgh","fbkfl","ogdail","ejehdmbk","mocmnio","mlfkgaab","dijb","mlbcnljogof","lnjadlm","ijgcicndm","cgnblkchngklbf","jbebfgk","hdjg","dl","honjckb","cdomnnhjocaoe","ebnje","igkgjalnbhinghi","iojginhi","fmmdnnjobikond","jeflgnl","noodabd","ojgd","nfkjdggjn","kajbdaikidneidm","klbjfcfjlkcibba","geecdcfbkede","ndjbgdadje","mokfehacdd","mjdkenofkaeli","mcmnj","mfggccd","nmonjefcjolhfgg","amdfecagjfkfdh","kbijncaeoon","febfhfjgkhdab","bgglmgmkjhne","mhhojoihflf","dfaffjcdnchb","mnh","fjcikedcd","odd","j","kjafgaiklcemkcd","lnhgochigmcgk","fnhijgnend","gniekccclcn","ofggcjlidbjeh","aojegacnehgbdgc","bbabogkdekleei","egcmokhdio","inl","fleeid","mmdcekhihfc","ckbbhaaoakfe","nadbaeddfjej","finiacgd","khid","haaiani","hekleijlafocdh","jihfh","aolhnacokig","nnggoafjl","fkhjghiaeojhi","oan","aajimcikcnaebe","achigecoboif","cjhed","ijhg","oonjh","allhnelgjdl","abh","cabncchfmbn","khnciickdoehol","jnof","bfmalenhf","bckmd","haln","iaiffadaadji","hoadjf","nagchlghjhk","hjlbacedkkdnk","ace","bmldoimodegcl","mdiojfhgmfg","omkblifelkfifjn","amnldcmobkkjmkj","iaibe","efnn","nmbf","a","foenajo","jgnkhn","ncagcgnfcfm","confnibafdeiiad","cdjgakfn","lmh","nlabndn","n","kc","gddjoojoeomanj","kmf","hj","jgnijhekbmbcbk","gjhfei","bfiladjlggjjh","fckgfmdeikdkkfi","abnldlg","fgnnjefaegg","mochafeafehelb","ncbdkecddnegbko","ceedljkegf","okhdgjkao","dfdcocheclaaj","ladkcaida","klfkbnbjeg","bihmahlknalkbb","gobo","edggcafghgbokfg","lfcdahkamfnnlbe","fhobdnbh","fllibcljdmajn","obhlnghf","njbcm","kmkbnlldhadfc","ghmk","ijbeihkojjml","clmbaleb","offmicbgejkh","hmmjfbkh","jkfehdlek","gbk","gmocchifcgmofhd","lbc","anicc","ejhddgheln","nemajmoebhjbkoj","naemi","nnenmabkhlm","bjhb","jmjhmnjkgh","admjcjbca","llem","hkbbe","nmdjmkjhdja","koniblnljgmmbbg","biljfalmflchb","dblnhfib","ok","emilcjdncm","ilfkbiodab","eoohdfhno","dgd","o","mbjj","legdidaoclb","nghlkbkbbljh","ekabk","ggkgfkbomme","ogfmlfcaklef","ikgg","kghbdjieniho","noighlblehf","jfmgihkonmbm","bimicdfhlifg","klimcfnojbiooc","lakbda","mkcoboaddi","nfaebmd","fbjlahcaajamjaj","gncllkii","fboglhliehal","jk","ocimnaceklgmoe","fcnh","ohcnnkamoaom","ccimaiofdealnjf","mkdanlkeekecc","hamboelbcdbai","lbljfeianmkhon","bhjbndfffcdhm","nafgoeceilmebn","jmb","fmmfmdmnigllb","dbaobkconcfcan","ajdibacdfg","iknhfe","abdaeca","l","becafg","eeieaeoiaagjbdi","odgfeca","anbceegkdn","bknkeonigb","fj","kacanki","jlkoncijbo","kaeobkadncbgn","eagocnmnjjhnlmh","adnnllieng","imlkbgfmolmj","nlmnkngheaof","kcockjm","ggmfbilldo","abagjicencjdhh","gedckmkehn","ijecleakkbndgl","joifkiccb","aiameogbecidakj","jdaiilnfh","kgdond","bnecbmebab","mfmlijibjdcoddh","nlcbiiejklclf","jlijddomde","gniiehcllnm","amj","fbcclace","ainmcmmhbc","cglfdaklhmmocl","hfkfdfkmlkai","hkfjjhejacc","kgm","anbhgnjhjfabiok","bdhmgigjbj","dokmfnldohbgk","cg","bgmkhfd","dfj","gjhd","idkmgmmnaejkdel","gekmbmmn","hccecjfbfij","cfek","fjeoegjlmligac","alhnjlacob","liedbjcj","adlif","okddmo","lgbkmbek","oobncia","moobambifbljk","gakogkghmihooak","hllhgdamoiej","lfkjddl","mjfb","ibngnkbicenfga","dombgn","kjboc","hdamjncmdol","hicl","obocccgm","ccomeiofkjnknga","acflfadojem","kl","odkcmjkfolgfnak","jlennlehfii","biimao","ghmaeadafbj","coggdjg","cdnchammeiegom","lofmfgelbmlehnc","jialklmcdlohkm","jbimboeijnbmgol","nndgm","hebjao","cijlobchgka","hljojiclje","gdb","kamgaigodfcbk","mi","lcjalnfojcmjbl","mdkmocngibmgnjb","fobhhgdf","dekdcobbeghi","elofjhgeackijdk","abjal","glnnkdccgi","kbcjlljgdnnbmi","bg","jnoffjafmaa","h","knhefdjjlaife","nbalab","jkhd","neaofeanlcidni","bdckcnlkbo","fkj","ihlknj","iggdjfk","nmmkjg","jhmimaem","minieag","fofgj","jafebbgi","cbanbcaknggl","nkncbcjlidilefo","filngail","oocb","hdhliiikjfhm","hfmaiekfb","af","hfjemfchd","hainei","mehfggjbghiomni","lcjnmbclgbin","djeokdahia","lh","lfbfoj","aohgcfcmbhmek","clfbgjichnmfa","chieogij","fglg","accifaokkgmnb","iamjljccnihcn","idocdnlj","dh","clhmcifbgcjf","bjmlcfhdjocgl","nbhajeoi","adeaadndhie","mlheaedi","jdbgkfadelbejhg","ohlecggkboamn","boinmneifn","angj","hoclbcdofng","gkjcegiifa","lakke","gfa","nnimh","iikjgcmfbagd","fefgjd","eeboefdackceb","mmkccjei","hloiook","hcge","gmhncohdjkk","clmkcojajn","ogjdgncmlh","dfookkmceiigmh","fhkjcimkiofoinn","mjahgdgnabdj","hb","obkkbdcjglm","le","cmninbjdhekcb","oodikoamlelcne","bnbafkkddmk","neagoocl","bhmdmlejaiji","mjlbealgl","cafnnmniln","labfg","leelb","ocifbibijfgdk","dbbb","ghbmcg","mom","igo","jcmfoebajefjdi","iikgmjn","obnckkadabjhfi","lhekmhildjkcn","njfogfnj","fcgacdhcclde","ichaeligmk","hmcjoigoea","cc","ickfcelfilkbk","ch","jkakkdlh","fkjjlb","dkcknlo","lc","nklohjhjif","jhgkjjfcjefc","kalkc","meglmnhlnem","lnbmmcbdgfkeem","ejkbobfilcnafel","lk","jlbncfd","eblmooggngamof","okmmomdmief","dahc","ackmjhnmfgaoafa","fmjgi","dbmflmfkdia","aeajncek","ehalibdilikeok","mnjojhdjngin","m","hfdlmjjcfmacb","ekciad","dkdfmnieiahio","nihfnbekbhk","okj","mmjf","anfjk","kocaoh","amfcflnla","jealekjf","fgokkddmfa","ffbbabn","okldhifhnhbm","edmaga","ajahiocomhbablk","danmbn","ilcjcheddnabll","ochfblfeldbo","ignhkon","meiailaib","aheodadm","dec","ianoghmba","bni","cenegah","jcnkiciendihdih","kegkcmnkh","fi","aeldnnmcbilelg","emejaicfjhafod","jjonddlecfgdm","elkcmmlfbiemeg","edebjfdocjh","ankghmibmgd","afmmgmi","afliaf","aecckchdf","mcnhfojki","la","blbaif","bifj","nkidce","ddhigddihlkm","bgjnn","haclkkjbjdjn","mcaehiiba","iebnfadil","kfgjab","bafdkg","gnbbgilljiacl","fdajjg","caiiokemdma","adfchcjninhho","meaaf","jahifegbhjj","hbhgkdl","egomnbc","ooccmbmicehi","afaecdcbjgf","mcaedecih","ihjnbgacjahfmj","hcnco","hbecolgk","jdknfnmjehoc","mnmbndjkono","mk","kmmcjjeab","lekbo","mcbaknmkcnebj","mbggg","men","jn","hgcchmkje","ncnlijanmcog","hll","jlhkhiggelnkhbk","bnoaah","enainmmdaamaicn","jieio","anadihbcbg","ligl","fmjkjmgmjmlonel","gifkkbkedeno","hmklhikf","jeoll","kbhi","cnkihoga","ihkndcibcgl","deogdlmcbc","mocghlg","gkaihhoa","miibddoebolibnc","ggecjoiodklb","nafdahhn","meboilne","olkhhkledm","hdklcdfmne","aclj","migeheccjgod","cejnilnhfadml","mfkmacdgomhcalm","faijmldniblnl","mmfcln","lhmdehaho","hcj","fkconhlmknloccn","hckhl","lheki","blenkofhj","bhjjgkmblen","dndjigjgikb","jnjamjglhim","hg","bnlbgllnkfemfgj","ll","hjekhnhnoam","mldahadgmegj","dmj","henklighfkah","lcl","lobhgifjflgcicc","chnfjdeije","jbaedijcdm","jcinegma","oojiijjcdh","bkejicnojmlj","jncnoc","embdomh","chkjonad","eekgln","aodogkkmodaoc","ee","ngnmdfldf","eajlnmjeckeek","lnnaiggam","hlohol","nibflancimmfk"};
*/
		String s = "catsanddog";
		String[] strings= new String[] {"cat","cats","and","sand","dog"};
		
		Set<String> set = new HashSet<>();
		set.addAll(Arrays.asList(strings));
		for (String ss: strings) {
			set.add(ss);
		}
		Solution so = new Solution();
		List<String> string = so.wordBreak2(s, set);
		System.out.println(string);
	}
}
