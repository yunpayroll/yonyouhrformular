package com.yunpayroll.formular.test;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import com.yunpayroll.formular.Parser;
import com.yunpayroll.formular.func.Ceiling;
import com.yunpayroll.formular.func.ConcatFunc;
import com.yunpayroll.formular.func.Floor;
import com.yunpayroll.formular.func.RoundFunc;
import com.yunpayroll.formular.func.Substring;

public class YonyouFormular {

	public static void main(String[] args)  throws  Exception {
		
		String[] vformula = new String[]{
				"wa_data.f12 like '%s%'",
				"case when (wa_data.f12 like '%s%') then 1 else 2 end",
				"-0xf",
				"-0.8",
				"-1",
				"updateFromAnotherPeriod(WOCLASS = 100187100000000006IT,WAITEM = f_51,WAYEAR = -1,WAPERIOD = -1)  ",
				"case when round ( ( wa_data.f_15 - 3000  ) / 12 , 0  ) <= 0 then 0 else round ( ( wa_data.f_15 - 3000  ) / 12 , 0  ) end  ",
				"round ( wa_data.f_16 * wa_data.f_17 , 0  )",
				"wa_data.f_16 - wa_data.f_18",
				"wa_data.f_19 * wa_data.f_20",
				"000187100000000002C1",
				"000187100000000002C0",
				"000187100000000002BZ",
				"000187100000000002C3",
				"wa_data.f_22 + wa_data.f_23 + wa_data.f_24 - wa_data.f_25",
				"case when wa_data.f_26 <= 0 then 0 else wa_data.f_26 end",
				"wa_data.f_18 / ( 21.75 * 8  ) * wa_data.f_29  ",
				"wa_data.f_18 / 21.75 * 0.5 * wa_data.f_33",
				"wa_data.f_30 + wa_data.f_34 + wa_data.f_36",
				"wa_data.f_16 / 21.75 * wa_data.f_38",
				"wa_data.f_37 + wa_data.f_39",
				"wa_data.f_18 + wa_data.f_21 + wa_data.f_28 + wa_data.f_43 - wa_data.f_40 - wa_data.f_44 + wa_data.f_45 + wa_data.f_46 + wa_data.f_47",
				"0.08",
				"case when bd_psndoc.groupdef6 = '000187100000000002ZP' then ceiling ( wa_data.f_49 * wa_data.f_50 * 10  ) / 10 else round ( wa_data.f_49 * wa_data.f_50 , 2  ) end",
				"case when bd_psndoc.groupdef6 = '000187100000000002ZO' then 0.2 when bd_psndoc.groupdef6 = '000187100000000003JD' and bd_psnbasdoc.characterrpr = 'HI700000000000002701' then 0.2 when bd_psndoc.groupdef6 = '000187100000000003JD' and bd_psnbasdoc.characterrpr = 'HI700000000000002702' and substring ( wa_data.f_103 , 1 , 4  ) = '四川成都' then 0.2 when bd_psndoc.groupdef6 = '000187100000000003JD' and bd_psnbasdoc.characterrpr = 'HI700000000000002702' and substring ( wa_data.f_103 , 1 , 4  ) <> '四川成都' then 0.12 when bd_psndoc.groupdef6 = '000187100000000004LI' then 0.18 when bd_psndoc.groupdef6 = '000187100000000003JE' and bd_psnbasdoc.characterrpr = 'HI700000000000002701' and substring ( wa_data.f_103 , 1 , 4  ) = '广东广州' then 0.2 when bd_psndoc.groupdef6 = '000187100000000003JE' and bd_psnbasdoc.characterrpr = 'HI700000000000002702' and substring ( wa_data.f_103 , 1 , 4  ) = '广东广州' then 0.12 when bd_psndoc.groupdef6 = '000187100000000003JE' and substring ( wa_data.f_103 , 1 , 4  ) <> '广东广州' then 0.12 when bd_psndoc.groupdef6 = '0001Q110000000001ECF' then 0.14 when bd_psndoc.groupdef6 = '000187100000000002ZP' then 0.21 when bd_psndoc.groupdef6 = '000187100000000002ZQ' and substring ( wa_data.f_103 , 1 , 4  ) = '广东深圳' then 0.14 when bd_psndoc.groupdef6 = '000187100000000002ZQ' and substring ( wa_data.f_103 , 1 , 4  ) <> '广东深圳' then 0.13 when bd_psndoc.groupdef6 = '0001Q110000000001ECG' then 0.2 when bd_psndoc.groupdef6 = '000187100000000003JF' then 0.18 else 0 end",
				"round ( wa_data.f_49 * wa_data.f_52 , 2  )",
				"wa_data.f_51 + wa_data.f_53",
				"case when bd_psndoc.groupdef6 = '000187100000000002ZO' and bd_psnbasdoc.characterrpr = 'HI700000000000002701' then 0.002 when bd_psndoc.groupdef6 = '000187100000000002ZO' and bd_psnbasdoc.characterrpr = 'HI700000000000002702' then 0 when bd_psndoc.groupdef6 = '000187100000000003JD' then 0.01 when bd_psndoc.groupdef6 = '000187100000000004LI' then 0.01 when bd_psndoc.groupdef6 = '000187100000000003JE' and bd_psnbasdoc.characterrpr = 'HI700000000000002701' then 0.005 when bd_psndoc.groupdef6 = '000187100000000003JE' and bd_psnbasdoc.characterrpr = 'HI700000000000002702' then 0 when bd_psndoc.groupdef6 = '0001Q110000000001ECF' and bd_psnbasdoc.characterrpr = 'HI700000000000002701' then 0.01 when bd_psndoc.groupdef6 = '0001Q110000000001ECF' and bd_psnbasdoc.characterrpr = 'HI700000000000002702' then 0 when bd_psndoc.groupdef6 = '000187100000000002ZP' then 0.005 when bd_psndoc.groupdef6 = '000187100000000002ZQ' then 0.01 when bd_psndoc.groupdef6 = '0001Q110000000001ECG' then 0.01 when bd_psndoc.groupdef6 = '000187100000000003JF' then 0.01 else 0 end",
				"case when bd_psndoc.groupdef6 = '000187100000000002ZP' then ceiling ( floor ( wa_data.f_55 * wa_data.f_56 * 100  ) / 10  ) / 10 else round ( wa_data.f_55 * wa_data.f_56 , 2  ) end",
				"case when bd_psndoc.groupdef6 = '000187100000000002ZO' then 0.01 when bd_psndoc.groupdef6 = '000187100000000003JD' then 0.02 when bd_psndoc.groupdef6 = '000187100000000004LI' then 0.01 when bd_psndoc.groupdef6 = '000187100000000003JE' then 0.012 when bd_psndoc.groupdef6 = '0001Q110000000001ECF' then 0.02 when bd_psndoc.groupdef6 = '000187100000000002ZP' then 0.015 when bd_psndoc.groupdef6 = '000187100000000002ZQ' then 0.02 when bd_psndoc.groupdef6 = '0001Q110000000001ECG' then 0.01 when bd_psndoc.groupdef6 = '000187100000000003JF' then 0.01 else 0 end",
				"round ( wa_data.f_55 * wa_data.f_58 , 2  )",
				"wa_data.f_57 + wa_data.f_59",
				"case when bd_psndoc.groupdef6 = '000187100000000002ZO' then 0.003 when bd_psndoc.groupdef6 = '000187100000000003JD' then 0.006 when bd_psndoc.groupdef6 = '000187100000000004LI' then 0.005 when bd_psndoc.groupdef6 = '000187100000000003JE' then 0.005 when bd_psndoc.groupdef6 = '0001Q110000000001ECF' then 0.01 when bd_psndoc.groupdef6 = '000187100000000002ZP' then 0.005 when bd_psndoc.groupdef6 = '000187100000000002ZQ' then 0.004 when bd_psndoc.groupdef6 = '0001Q110000000001ECG' then 0.005 when bd_psndoc.groupdef6 = '000187100000000003JF' then 0.01 else 0 end",
				"round ( wa_data.f_61 * wa_data.f_62 , 2  )",
				"case when bd_psndoc.groupdef6 = '000187100000000002ZO' then 0.008 when bd_psndoc.groupdef6 = '000187100000000003JD' then 0.006 when bd_psndoc.groupdef6 = '000187100000000004LI' then 0.007 when bd_psndoc.groupdef6 = '000187100000000003JE' then 0.0085 when bd_psndoc.groupdef6 = '0001Q110000000001ECF' then 0.0007 when bd_psndoc.groupdef6 = '000187100000000002ZP' then 0.01 when bd_psndoc.groupdef6 = '000187100000000002ZQ' then 0.005 when bd_psndoc.groupdef6 = '0001Q110000000001ECG' then 0.007 when bd_psndoc.groupdef6 = '000187100000000003JF' then 0.007 else 0 end",
				"round ( wa_data.f_64 * wa_data.f_65 , 2  )",
				"case when bd_psndoc.groupdef6 = '000187100000000002ZO' then 0.02 when bd_psndoc.groupdef6 = '000187100000000003JD' and bd_psnbasdoc.characterrpr = 'HI700000000000002701' then 0.02 when bd_psndoc.groupdef6 = '000187100000000003JD' and bd_psnbasdoc.characterrpr = 'HI700000000000002702' and substring ( wa_data.f_103 , 1 , 4  ) = '四川成都' then 0.02 when bd_psndoc.groupdef6 = '000187100000000003JD' and bd_psnbasdoc.characterrpr = 'HI700000000000002702' and substring ( wa_data.f_103 , 1 , 4  ) <> '四川成都' then 0 when bd_psndoc.groupdef6 = '000187100000000004LI' then 0.02 when bd_psndoc.groupdef6 = '000187100000000003JE' then 0.02 when bd_psndoc.groupdef6 = '0001Q110000000001ECF' then 0.02 when bd_psndoc.groupdef6 = '000187100000000002ZP' and bd_psnbasdoc.characterrpr = 'HI700000000000002701' then 0.02 when bd_psndoc.groupdef6 = '000187100000000002ZP' and bd_psnbasdoc.characterrpr = 'HI700000000000002702' then 0.01 when bd_psndoc.groupdef6 = '000187100000000002ZQ' then 0.02 when bd_psndoc.groupdef6 = '0001Q110000000001ECG' then 0.02 when bd_psndoc.groupdef6 = '000187100000000003JF' then 0.02 else 0 end",
				"case when bd_psndoc.groupdef6 = '000187100000000002ZO' and wa_data.f_67 > 0 then wa_data.f_67 * wa_data.f_68 + 3 when bd_psndoc.groupdef6 = '000187100000000002ZP' and wa_data.f_67 > 0 then ceiling ( wa_data.f_67 * wa_data.f_68 * 10  ) / 10 else round ( wa_data.f_67 * wa_data.f_68 , 2  ) end",
				"case when bd_psndoc.groupdef6 = '000187100000000002ZO' then 0.1 when bd_psndoc.groupdef6 = '000187100000000003JD' and bd_psnbasdoc.characterrpr = 'HI700000000000002701' then 0.065 when bd_psndoc.groupdef6 = '000187100000000003JD' and bd_psnbasdoc.characterrpr = 'HI700000000000002702' and substring ( wa_data.f_103 , 1 , 4  ) = '四川成都' then 0.065 when bd_psndoc.groupdef6 = '000187100000000003JD' and bd_psnbasdoc.characterrpr = 'HI700000000000002702' and substring ( wa_data.f_103 , 1 , 4  ) <> '四川成都' then 0.025 when bd_psndoc.groupdef6 = '000187100000000004LI' then 0.08 when bd_psndoc.groupdef6 = '000187100000000003JE' then 0.08 when bd_psndoc.groupdef6 = '0001Q110000000001ECF' then 0.11 when bd_psndoc.groupdef6 = '000187100000000002ZP' and bd_psnbasdoc.characterrpr = 'HI700000000000002701' then 0.11 when bd_psndoc.groupdef6 = '000187100000000002ZP' and bd_psnbasdoc.characterrpr = 'HI700000000000002702' then 0.06 when bd_psndoc.groupdef6 = '000187100000000002ZQ' then 0.062 when bd_psndoc.groupdef6 = '0001Q110000000001ECG' then 0.08 when bd_psndoc.groupdef6 = '000187100000000003JF' then 0.075 else 0 end",
				"round ( wa_data.f_67 * wa_data.f_70 , 2  )",
				"wa_data.f_69 + wa_data.f_71",
				"case when bd_psndoc.groupdef6 = '000187100000000003JD' then 0.01 else 0 end",
				"case when bd_psndoc.groupdef6 = '000187100000000003JE' then 13.81 when bd_psndoc.groupdef6 = '0001Q110000000001ECF' then 13.81 else round ( wa_data.f_73 * wa_data.f_74 , 2  ) end",
				"case when bd_psndoc.groupdef6 = '000187100000000002ZP' then 0.07 else 0.12 end",
				"case when bd_psndoc.groupdef6 = '000187100000000002ZQ' then round ( wa_data.f_76 * wa_data.f_77 , 2  ) else round ( wa_data.f_76 * wa_data.f_77 , 0  ) end",
				"case when bd_psndoc.groupdef6 = '000187100000000002ZP' then 0.07 else 0.12 end",
				"case when bd_psndoc.groupdef6 = '000187100000000002ZQ' then round ( wa_data.f_76 * wa_data.f_79 , 2  ) else round ( wa_data.f_76 * wa_data.f_79 , 0  ) end",
				"wa_data.f_78 + wa_data.f_80",
				"case when bd_psndoc.groupdef6 = '000187100000000002ZP' then 0.05 else 0 end",
				"round ( wa_data.f_82 * wa_data.f_83 , 0  )",
				"case when bd_psndoc.groupdef6 = '000187100000000002ZP' then 0.05 else 0 end",
				"round ( wa_data.f_82 * wa_data.f_85 , 0  )",
				"wa_data.f_84 + wa_data.f_86",
				"wa_data.f_78 + wa_data.f_84",
				"wa_data.f_80 + wa_data.f_86",
				"wa_data.f_88 + wa_data.f_89",
				"valueOfSubtable(bd_psnbasdoc.permanreside={select max(bd_defdoc.docname) from bd_defdoc where bd_defdoc.pk_defdoc = bd_psnbasdoc.permanreside},@BFV_LOGDATE@)",
				"valueOfSubtable(bd_psndoc.groupdef6={select bd_defdoc.docname from bd_defdoc where bd_defdoc.pk_defdoc = bd_psndoc.groupdef6},@BFV_LOGDATE@)",
				"valueOfSubtable(bd_psnbasdoc.characterrpr={select max(bd_defdoc.docname) from bd_defdoc where bd_defdoc.pk_defdoc = bd_psnbasdoc.characterrpr},@BFV_LOGDATE@)",
				"wa_data.f_51 + wa_data.f_51 * wa_data.f_131 + wa_data.f_201",
				"wa_data.f_53 + wa_data.f_53 * wa_data.f_131 + wa_data.f_171",
				"wa_data.f_132 + wa_data.f_133",
				"wa_data.f_57 + wa_data.f_57 * wa_data.f_131 + wa_data.f_205",
				"wa_data.f_59 + wa_data.f_59 * wa_data.f_131 + wa_data.f_204",
				"wa_data.f_135 + wa_data.f_136",
				"case when wa_data.f_105 = '成都' then wa_data.f_63 else ( wa_data.f_63 + wa_data.f_63 * wa_data.f_131  ) + wa_data.f_206 end",
				"wa_data.f_66 + wa_data.f_66 * wa_data.f_131 + wa_data.f_207",
				"wa_data.f_69 + wa_data.f_69 * wa_data.f_131 + wa_data.f_203",
				"wa_data.f_71 + wa_data.f_71 * wa_data.f_131 + wa_data.f_202",
				"wa_data.f_75 + wa_data.f_75 * wa_data.f_131",
				"wa_data.f_140 + wa_data.f_141 + wa_data.f_142 + wa_data.f_215",
				"wa_data.f_78 + wa_data.f_78 * wa_data.f_131 + wa_data.f_209",
				"wa_data.f_80 + wa_data.f_80 * wa_data.f_131 + wa_data.f_208",
				"wa_data.f_84 + wa_data.f_84 * wa_data.f_131",
				"wa_data.f_86 + wa_data.f_86 * wa_data.f_131",
				"wa_data.f_144 + wa_data.f_146",
				"wa_data.f_145 + wa_data.f_147",
				"wa_data.f_149 + wa_data.f_148",
				"wa_data.f_132 + wa_data.f_135 + wa_data.f_140 + wa_data.f_215 + wa_data.f_148",
				"wa_data.f_133 + wa_data.f_136 + wa_data.f_138 + wa_data.f_139 + wa_data.f_141 + wa_data.f_142 + wa_data.f_149",
				"wa_data.f_152 + wa_data.f_151",
				"wa_data.f_48 - wa_data.f_151 + wa_data.f_154 - wa_data.f_155 + wa_data.f_156",
				"wa_data.f_4 + wa_data.f_158 + wa_data.f_159",
				"case when wa_data.f_216 > 0 then wa_data.f_53 - wa_data.f_223 else 0 end  ",
				"case when wa_data.f_216 > 0 then wa_data.f_51 - wa_data.f_222 else 0 end  ",
				"case when wa_data.f_216 > 0 then wa_data.f_71 - wa_data.f_227 else 0 end  ",
				"case when wa_data.f_216 > 0 then wa_data.f_69 - wa_data.f_226 else 0 end  ",
				"case when wa_data.f_216 > 0 then wa_data.f_59 - wa_data.f_225 else 0 end  ",
				"case when wa_data.f_216 > 0 then wa_data.f_57 - wa_data.f_224 else 0 end  ",
				"case when wa_data.f_216 > 0 then wa_data.f_63 - wa_data.f_228 else 0 end  ",
				"case when wa_data.f_216 > 0 then wa_data.f_66 - wa_data.f_229 else 0 end  ",
				"case when wa_data.f_216 > 0 then wa_data.f_80 + wa_data.f_86 - wa_data.f_231 - wa_data.f_233 else 0 end  ",
				"case when wa_data.f_216 > 0 then wa_data.f_78 + wa_data.f_84 - wa_data.f_230 - wa_data.f_232 else 0 end  ",
				"0",
				"case when bd_psndoc.groupdef6 = '0001Q110000000001ECG' then 7 else 0 end",
				"wa_data.f_214 + wa_data.f_214 * wa_data.f_131",
				"case when wa_data.f_219 <= 3 then 0 when bd_psndoc.dutyname = '000187100000000003MQ' then ( wa_data.f_219 - 3  ) * 200 else ( wa_data.f_219 - 3  ) * 100 end  ",
				"updateFromAnotherPeriod(WOCLASS = 100187100000000006IT,WAITEM = f_51,WAYEAR = -1,WAPERIOD = -1)  ",
				"updateFromAnotherPeriod(WOCLASS = 100187100000000006IT,WAITEM = f_53,WAYEAR = -1,WAPERIOD = -1)  ",
				"updateFromAnotherPeriod(WOCLASS = 100187100000000006IT,WAITEM = f_57,WAYEAR = -1,WAPERIOD = -1)  ",
				"updateFromAnotherPeriod(WOCLASS = 100187100000000006IT,WAITEM = f_59,WAYEAR = -1,WAPERIOD = -1)  ",
				"updateFromAnotherPeriod(WOCLASS = 100187100000000006IT,WAITEM = f_69,WAYEAR = -1,WAPERIOD = -1)  ",
				"updateFromAnotherPeriod(WOCLASS = 100187100000000006IT,WAITEM = f_71,WAYEAR = -1,WAPERIOD = -1)  ",
				"updateFromAnotherPeriod(WOCLASS = 100187100000000006IT,WAITEM = f_63,WAYEAR = -1,WAPERIOD = -1)  ",
				"updateFromAnotherPeriod(WOCLASS = 100187100000000006IT,WAITEM = f_66,WAYEAR = -1,WAPERIOD = -1)  ",
				"updateFromAnotherPeriod(WOCLASS = 100187100000000006IT,WAITEM = f_78,WAYEAR = -1,WAPERIOD = -1)  ",
				"updateFromAnotherPeriod(WOCLASS = 100187100000000006IT,WAITEM = f_80,WAYEAR = -1,WAPERIOD = -1)  ",
				"updateFromAnotherPeriod(WOCLASS = 100187100000000006IT,WAITEM = f_84,WAYEAR = -1,WAPERIOD = -1)  ",
				"updateFromAnotherPeriod(WOCLASS = 100187100000000006IT,WAITEM = f_86,WAYEAR = -1,WAPERIOD = -1)  ",
				"000187100000000002BQ",
				"000187100000000002BR",
				"000187100000000002BT",
				"latecount"
		};
		for(String vString:vformula) {
			System.out.println(vString);
			Parser parser = new Parser(new StringReader(vString.trim()));
//				Parser parser = new Parser(new StringReader("case a  when 1 then 1 else 3 end"));
			parser.addGlobalVar("BFV_NATURE_MONTH", "2017-01-01");
			parser.addVariable("a", 1l);
			
			Map<String,Object> psn = new HashMap<String, Object>();
			psn.put("groupdef6", "000187100000000003JF");
			psn.put("dutyname", "000187100000000003MQ");
			
			parser.addVariable("bd_psndoc",psn );
			
			
			
			Map<String,Object> psnbase = new HashMap<String, Object>();
			psnbase.put("characterrpr", "HI700000000000002701");
			parser.addVariable("bd_psnbasdoc",psnbase );
			
			
			Map<String,Object> wa = new HashMap<String, Object>();
			wa.put("f_15", 30000l);
			wa.put("f_16", 3000l);
		 
			for(int i=17;i<300;i++){
				wa.put("f_"+i, 1l);
			}
			
			parser.addVariable("wa_data",wa );
			
			parser.addFunction("concat", new ConcatFunc());
			parser.addFunction("round", new RoundFunc());
			parser.addFunction("ceiling", new Ceiling());
			parser.addFunction("substring", new Substring());
			parser.addFunction("floor", new Floor());
			Object v = parser.getValue();
			System.out.println(v);
			 
			
		}
		
	}

}
