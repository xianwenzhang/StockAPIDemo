package com.helen.stockchart;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.csf.csflibrary.callback.ContributorView;
import com.csf.csflibrary.constant.Constant;
import com.csf.csflibrary.presenter.ContributorPresenter;

import java.util.ArrayList;
import java.util.List;

public class StockTestActivity extends Activity implements ContributorView, AdapterView.OnItemClickListener {

    private ApplicationInfo appInfo;
    private String AccessKey;//AccessKey
    private String SecretKey;//SecretKey
    private TextView tv_test;
    private ListView lv_interfacename;
    private Context mContext;
    private String[] text = new String[]{"股票简况和股东股本", "股票搜索", "股票分红转增", "股票前十大股东信息", "融资融券/沪港通股票判断", "股票增发实施", "新股列表", "新股日历", "新股申购详情", "次新股",
            "股票实时状态", "股票最新资金流向占比", "股票近5日主力资金增减仓", "股票成交额榜", "股票涨跌幅榜", "股票换手率榜", "股票资金流向排行榜", "股票分时数据", "股票5日分时数据", "股票日度行情历史数据",
            "股票周度行情历史数据", "股票月度行情历史数据", "股票五档委托信息", "建议目标价和当前价", "个股全貌", "个股标签表", "股票相关新闻", "股票相关公告", "股票相关研报",
            "资产负债表", "利润表", "现金流量表", "财务科目表", "成份股涨跌幅榜", "成份股换手率", "最新主力资金流向占比", "近5日主力资金增减仓", "实时主力资金流向", "大盘指数当日分时数据",
            "大盘指数近5日分时数据", "大盘指数日度行情历史数据", "大盘指数周度行情历史数据", "大盘指数月度行情历史数据", "指数字典表", "指数样本股", "实时状态", "指数日度行情历史数据",
            "指数风云榜", "概念指数涨幅榜", "概念指数成份股涨跌幅详情", "行业/概念资金流向排行榜", "行业/概念资金流入榜详情", "行业/概念资金流向占比", "行业/概念最近五日主力增减仓",
            "标签相关新闻", "热点新闻", "股票类新闻", "新闻详情", "公告类型列表", "公告类型事件详情列表", "新闻热股", "股票配股", "个股停牌表", "大盘指数实时状态",
            "SAM产品搜索", "数库行业分类（查股票）", "产业链", "数库行业对应宏观指标", "宏观指标列表", "宏观指标详情", "新闻热股详情", "新三板基础信息", "新三板股东信息", "新三板日度行情历史数据"
            , "新三板财务科目表", "新三板资产负债表", "新三板利润表", "新三板现金流量表", "新三板增发实施", "新三板增发对象明细",
            "基金资讯列表", "基金资讯详情", "基金实时估值明细", "基金实时估值排名", "基金实时估值走势",
            "基金搜索", "基金收益排行榜", "基金收益对比和排名", "周领涨板块对应基金", "基金定投收益", "行业/概念基金推荐", "基金推荐",
            "基金诊断之收益", "基金诊断之重仓股债", "基金推荐详情之股价", "基金推荐详情之新闻", "基金筛选", "基金基本信息", "数库基金分类", "基金综合详情",
            "基金历史净值", "基金收益走势", "基金风险指标", "基金历史分红拆分信息", "基金定投", "基金经理列表", "基金经理基本信息", "基金历任经理", "基金公司基本信息",
            "基金公司产品类型统计", "基金公司类型产品明细", "基金公司重仓持股", "行业标签列表", "主题标签列表", "风格标签列表", "基金标签筛选", "基金评级", "基金经理评级", "基金资产分布", "基金重仓行业", "基金重仓股票", "基金重仓债券",
            "最热股票排行", "SAM行业排行", "基金公司排行", "基金产品排行", "SAM最热股票", "实时热点新闻", "事件情感分析", "实体抽取分析", "摘要抽取分析", "产业链图谱分析", "股票对应新闻信息", "新闻股票信息", "新闻情感信息", "研报股票信息",
            "活跃主题列表", "主题活跃度", "主题历史相关股票", "证券列表", "数库行业分类（查行业）", "按类型查询股票公告", "研报三个月目标价", "交易日历表", "基金经理评级历史", "基金和基金经理最新评级"
    };
    private List<String> titles = new ArrayList<>();

    private EditText et_first;
    private EditText et_second;
    private EditText et_third;
    private EditText et_four;
    private EditText et_five;
    private EditText et_six;
    private ContributorPresenter contributorPresenter;
    List<String> texts;
    private String flag = "flag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_test);
        mContext = this;
        tv_test = (TextView) findViewById(R.id.tv_test);
        lv_interfacename = (ListView) findViewById(R.id.lv_interfacename);
        AccessKey = getAppInfo().metaData.getString("CSF_ACCESSKEY");
        SecretKey = getAppInfo().metaData.getString("CSF_SECRETKEY");
        initData();
    }

    public void initData() {
        for (int i = 0; i < text.length; i++) {
            titles.add(text[i] + "[" + (i + 1) + "]");
        }
        ArrayAdapter adapter = new ArrayAdapter(mContext, R.layout.item_text, R.id.tv_text, titles);
        lv_interfacename.setAdapter(adapter);
        lv_interfacename.setOnItemClickListener(this);
        contributorPresenter = new ContributorPresenter(this, this, AccessKey, SecretKey);
    }

    public ApplicationInfo getAppInfo() {
        if (appInfo == null) {
            try {
                appInfo = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);

            } catch (PackageManager.NameNotFoundException e) {

            }
        }
        return appInfo;
    }

    @Override
    public void onLoadContributorStart() {

    }


    @Override
    public void onLoadContributorSuccess(String jsonString, String flag) {
        Log.e("http地址：", jsonString);
        Intent intent = new Intent(mContext, ShowResultActivity.class);
        intent.putExtra("text", jsonString.toString());
        startActivity(intent);

    }


    @Override
    public void onLoadContributorComplete() {
    }

    @Override
    public void onLoadContributorError(String error) {
        Intent intent = new Intent(mContext, ShowResultActivity.class);
        intent.putExtra("text", error);
        startActivity(intent);
    }


    private void showDialog(final int position, List<String> params) {
        final Dialog dialog = new Dialog(this, R.style.CustomProgressDialog);
        View view = LayoutInflater.from(mContext).inflate(R.layout.custom_stock_dialog_layout, null);
        dialog.setContentView(view);
        Button tvConfirm = (Button) view.findViewById(R.id.tv_next);
        Button tvCancel = (Button) view.findViewById(R.id.tv_back);
        TextView tv_first = (TextView) view.findViewById(R.id.tv_first);
        TextView tv_second = (TextView) view.findViewById(R.id.tv_second);
        TextView tv_third = (TextView) view.findViewById(R.id.tv_third);
        TextView tv_four_hint = (TextView) view.findViewById(R.id.tv_four_hint);
        TextView tv_five_hint = (TextView) view.findViewById(R.id.tv_five_hint);
        TextView tv_six_hint = (TextView) view.findViewById(R.id.tv_six_hint);
        et_first = (EditText) view.findViewById(R.id.et_first);
        et_second = (EditText) view.findViewById(R.id.et_second);
        et_third = (EditText) view.findViewById(R.id.et_third);
        et_four = (EditText) view.findViewById(R.id.et_four);
        et_five = (EditText) view.findViewById(R.id.et_five);
        et_six = (EditText) view.findViewById(R.id.et_six);

        if (null != params && params.size() > 0) {
            if (params.size() == 1) {
                tv_first.setText(params.get(0));
                tv_second.setText("--");
                tv_third.setText("--");
                tv_four_hint.setText("--");
                tv_five_hint.setText("--");
            } else if (params.size() == 2) {
                tv_first.setText(params.get(0));
                tv_second.setText(params.get(1));
                tv_third.setText("--");
                tv_four_hint.setText("--");
                tv_five_hint.setText("--");
            } else if (params.size() == 3) {
                tv_first.setText(params.get(0));
                tv_second.setText(params.get(1));
                tv_third.setText(params.get(2));
                tv_four_hint.setText("--");
                tv_five_hint.setText("--");
            } else if (params.size() == 4) {
                tv_first.setText(params.get(0));
                tv_second.setText(params.get(1));
                tv_third.setText(params.get(2));
                tv_four_hint.setText(params.get(3));
                tv_five_hint.setText("--");
            } else if (params.size() == 5) {
                tv_first.setText(params.get(0));
                tv_second.setText(params.get(1));
                tv_third.setText(params.get(2));
                tv_four_hint.setText(params.get(3));
                tv_five_hint.setText(params.get(4));
            } else if (params.size() == 6) {
                tv_first.setText(params.get(0));
                tv_second.setText(params.get(1));
                tv_third.setText(params.get(2));
                tv_four_hint.setText(params.get(3));
                tv_five_hint.setText(params.get(4));
                tv_six_hint.setText(params.get(5));
            } else if (params.size() == 7) {
                tv_first.setText(params.get(0));
                tv_second.setText(params.get(1));
                tv_third.setText(params.get(2));
                tv_four_hint.setText(params.get(3));
                tv_five_hint.setText(params.get(4));
                tv_six_hint.setText(params.get(5));
            }
        } else {
            tv_first.setText("--");
            tv_second.setText("--");
            tv_third.setText("--");
            tv_four_hint.setText("--");
            tv_five_hint.setText("--");
        }

        tvConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (position == 1) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getStockSummary(fParams, flag);
                    } else if (position == 2) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        if (null == sParams || "".equals(sParams)) {
                            contributorPresenter.getStockSearch(fParams, 10, flag);
                        } else {
                            contributorPresenter.getStockSearch(fParams, Integer.valueOf(sParams), flag);
                        }
                    } else if (position == 3) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getStockBonus(fParams, flag);
                    } else if (position == 4) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getStockHolders(fParams, flag);
                    } else if (position == 5) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getStockCateGoryCheck(fParams, flag);
                    } else if (position == 6) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getStockAdditional(fParams, flag);
                    } else if (position == 7) {
                        contributorPresenter.getStockIpoList(flag);
                    } else if (position == 8) {
                        contributorPresenter.getStockIpoCalendar(flag);
                    } else if (position == 9) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getStockIpoSubscribeDetail(fParams, flag);
                    } else if (position == 10) {
                        contributorPresenter.getStockSubnew(flag);
                    } else if (position == 11) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getStockRealtimeState(fParams, flag);
                    } else if (position == 12) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getStockCapitalFlowsLatest(fParams, flag);
                    } else if (position == 13) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getStockCapitalFlowsMain(fParams, flag);
                    } else if (position == 14) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        if (null == fParams || "".equals(fParams)) {
                            contributorPresenter.getStockAmountRanking(1, 0, 10, flag);
                        } else {
                            if (null == sParams || "".equals(sParams) || null == tParams || "".equals(tParams)) {
                                contributorPresenter.getStockAmountRanking(Integer.valueOf(fParams), 0, 10, flag);
                            } else {
                                contributorPresenter.getStockAmountRanking(Integer.valueOf(fParams), Integer.valueOf(sParams), Integer.valueOf(tParams), flag);
                            }
                        }
                    } else if (position == 15) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        if (null == fParams || "".equals(fParams)) {
                            contributorPresenter.getStockRatioRanking(1, 0, 10, flag);
                        } else {
                            if (null == sParams || "".equals(sParams) || null == tParams || "".equals(tParams)) {
                                contributorPresenter.getStockRatioRanking(Integer.valueOf(fParams), 0, 10, flag);
                            } else {
                                contributorPresenter.getStockRatioRanking(Integer.valueOf(fParams), Integer.valueOf(sParams), Integer.valueOf(tParams), flag);
                            }
                        }
                    } else if (position == 16) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        if (null == fParams || "".equals(fParams)) {
                            contributorPresenter.getStockTurnoverRanking(1, 0, 10, flag);
                        } else {
                            if (null == sParams || "".equals(sParams) || null == tParams || "".equals(tParams)) {
                                contributorPresenter.getStockTurnoverRanking(Integer.valueOf(fParams), 0, 10, flag);
                            } else {
                                contributorPresenter.getStockTurnoverRanking(Integer.valueOf(fParams), Integer.valueOf(sParams), Integer.valueOf(tParams), flag);
                            }
                        }
                    } else if (position == 17) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        String foParams = et_four.getText().toString();
                        if (null == fParams || "".equals(fParams)) {
                            contributorPresenter.getStockCapitalFlowsRanking(1, 1, 0, 10, flag);
                        } else {
                            if (null == sParams || "".equals(sParams)) {
                                contributorPresenter.getStockCapitalFlowsRanking(Integer.valueOf(fParams), 1, 0, 10, flag);
                            } else {
                                if (null == tParams || "".equals(tParams) || null == foParams || "".equals(foParams)) {
                                    contributorPresenter.getStockCapitalFlowsRanking(Integer.valueOf(fParams), Integer.valueOf(sParams), 0, 10, flag);
                                } else {
                                    contributorPresenter.getStockCapitalFlowsRanking(Integer.valueOf(fParams), Integer.valueOf(sParams), Integer.valueOf(tParams), Integer.valueOf(foParams), flag);
                                }
                            }
                        }
                    } else if (position == 18) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        if (null == tParams || "".equals(tParams)) {
                            contributorPresenter.getStockTimeShareDaily(fParams, sParams, 0, flag);
                        } else {
                            contributorPresenter.getStockTimeShareDaily(fParams, sParams, Integer.valueOf(tParams), flag);
                        }
                    } else if (position == 19) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        if (null == tParams || "".equals(tParams)) {
                            contributorPresenter.getStockTimeShareWeek(fParams, sParams, 0, flag);
                        } else {
                            contributorPresenter.getStockTimeShareWeek(fParams, sParams, Integer.valueOf(tParams), flag);
                        }
                    } else if (position == 20) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        String foParams = et_four.getText().toString();
                        contributorPresenter.getStockPriceDaily(fParams, sParams, tParams, foParams, flag);
                    } else if (position == 21) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        String foParams = et_four.getText().toString();
                        contributorPresenter.getStockPriceWeekly(fParams, sParams, tParams, foParams, flag);
                    } else if (position == 22) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        String foParams = et_four.getText().toString();
                        contributorPresenter.getStockPriceMonthly(fParams, sParams, tParams, foParams, flag);
                    } else if (position == 23) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getStockRealtimeTradeState(fParams, flag);
                    } else if (position == 24) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getStockEvaluationSummary(fParams, flag);
                    } else if (position == 25) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getStockEvaluationOverView(fParams, flag);
                    } else if (position == 26) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getStockIdxTag(fParams, flag);
                    } else if (position == 27) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        if (null == sParams || "".equals(sParams) || null == tParams || "".equals(tParams)) {
                            contributorPresenter.getStockNews(fParams, 0, 10, flag);
                        } else {
                            contributorPresenter.getStockNews(fParams, Integer.valueOf(sParams), Integer.valueOf(tParams), flag);
                        }
                    } else if (position == 28) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        if (null == sParams || "".equals(sParams) || null == tParams || "".equals(tParams)) {
                            contributorPresenter.getStockAnnouncement(fParams, 0, 10, flag);
                        } else {
                            contributorPresenter.getStockAnnouncement(fParams, Integer.valueOf(sParams), Integer.valueOf(tParams), flag);
                        }
                    } else if (position == 29) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        if (null == sParams || "".equals(sParams) || null == tParams || "".equals(tParams)) {
                            contributorPresenter.getStockReport(fParams, 0, 10, flag);
                        } else {
                            contributorPresenter.getStockReport(fParams, Integer.valueOf(sParams), Integer.valueOf(tParams), flag);
                        }
                    } else if (position == 30) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        String foParams = et_four.getText().toString();
                        String fiParams = et_five.getText().toString();
                        contributorPresenter.getFinanceBalance(fParams, sParams, tParams, foParams, fiParams, flag);
                    } else if (position == 31) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        String foParams = et_four.getText().toString();
                        String fiParams = et_five.getText().toString();
                        String siParams = et_six.getText().toString();
                        contributorPresenter.getFinanceIncomes(fParams, sParams, tParams, foParams, fiParams, siParams, flag);
                    } else if (position == 32) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        String foParams = et_four.getText().toString();
                        String fiParams = et_five.getText().toString();
                        String siParams = et_six.getText().toString();
                        contributorPresenter.getFinanceCash(fParams, sParams, tParams, foParams, fiParams, siParams, flag);
                    } else if (position == 33) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getFinanceItems(fParams, flag);
                    } else if (position == 34) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        String foParams = et_four.getText().toString();
                        if (null == sParams || "".equals(sParams) || null == tParams || "".equals(tParams) || null == foParams || "".equals(foParams)) {
                            contributorPresenter.getMktIndexStkRatioRanking(fParams, 1, 0, 10, flag);
                        } else {
                            contributorPresenter.getMktIndexStkRatioRanking(fParams, Integer.valueOf(sParams), Integer.valueOf(tParams), Integer.valueOf(foParams), flag);
                        }
                    } else if (position == 35) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        String foParams = et_four.getText().toString();
                        if (null == sParams || "".equals(sParams) || null == tParams || "".equals(tParams) || null == foParams || "".equals(foParams)) {
                            contributorPresenter.getMktIndexStkTurnoverRanking(fParams, 1, 0, 10, flag);
                        } else {
                            contributorPresenter.getMktIndexStkTurnoverRanking(fParams, Integer.valueOf(sParams), Integer.valueOf(tParams), Integer.valueOf(foParams), flag);
                        }
                    } else if (position == 36) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getMktIndexCapitalFlowsLatest(fParams, flag);
                    } else if (position == 37) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getMktIndexCapitalFlowsMain(fParams, flag);
                    } else if (position == 38) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getMktIndexCapitalFlowsRealtime(fParams, flag);
                    } else if (position == 39) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        if (null == tParams || "".equals(tParams)) {
                            contributorPresenter.getHQIndexTimeShareDaily(fParams, sParams, 0, flag);
                        } else {
                            contributorPresenter.getHQIndexTimeShareDaily(fParams, sParams, Integer.valueOf(tParams), flag);
                        }
                    } else if (position == 40) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        if (null == tParams || "".equals(tParams)) {
                            contributorPresenter.getHQIndexTimeShareWeek(fParams, sParams, 0, flag);
                        } else {
                            contributorPresenter.getHQIndexTimeShareWeek(fParams, sParams, Integer.valueOf(tParams), flag);
                        }
                    } else if (position == 41) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        contributorPresenter.getHQIndexPriceDaily(fParams, sParams, tParams, flag);
                    } else if (position == 42) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        contributorPresenter.getHQIndexPriceWeekly(fParams, sParams, tParams, flag);
                    } else if (position == 43) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        contributorPresenter.getHQIndexPriceMonthly(fParams, sParams, tParams, flag);
                    } else if (position == 44) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getCSFIndexDict(fParams, flag);
                    } else if (position == 45) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        if (sParams.isEmpty()) {
                            contributorPresenter.getCSFIndexStock(fParams, Constant.SZH, flag);
                        } else if (sParams.equals(Constant.SZH) || sParams.equals(Constant.EN) || sParams.equals(Constant.szh) || sParams.equals(Constant.en)) {
                            contributorPresenter.getCSFIndexStock(fParams, sParams, flag);
                        }

                    } else if (position == 46) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getCSFIndexRealtimeState(fParams, flag);
                    } else if (position == 47) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        contributorPresenter.getCSFIndexDailyHistory(fParams, sParams, tParams, flag);
                    } else if (position == 48) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        if (null == fParams || "".equals(fParams)) {
                            contributorPresenter.getCSFIndexBollboard(0, 0, 10, flag);
                        } else {
                            if (null == sParams || "".equals(sParams) || null == tParams || "".equals(tParams)) {
                                contributorPresenter.getCSFIndexBollboard(Integer.valueOf(fParams), 0, 10, flag);
                            } else {
                                contributorPresenter.getCSFIndexBollboard(Integer.valueOf(fParams), Integer.valueOf(sParams), Integer.valueOf(tParams), flag);
                            }
                        }
                    } else if (position == 49) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        String fparams = et_four.getText().toString();
                        if (null == fParams || "".equals(fParams)) {
                            contributorPresenter.getCSFIndexRatioRanking(-1, 0, 10, 1, flag);
                        } else {
                            if (null == sParams || "".equals(sParams) || null == tParams || "".equals(tParams) || null == fparams || "".equals(fparams)) {
                                contributorPresenter.getCSFIndexRatioRanking(Integer.valueOf(fParams), 0, 10, 1, flag);
                            } else {
                                contributorPresenter.getCSFIndexRatioRanking(Integer.valueOf(fParams), Integer.valueOf(sParams), Integer.valueOf(tParams), Integer.valueOf(fparams), flag);
                            }
                        }
                    } else if (position == 50) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getCSFIndexRatioDetail(fParams, flag);
                    } else if (position == 51) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        String foParams = et_four.getText().toString();
                        if (null == fParams || "".equals(fParams)) {
                            contributorPresenter.getCSFIndexCapitalFlowsRanking(1, 1, 0, 10, flag);
                        } else {
                            if (null == sParams || "".equals(sParams)) {
                                contributorPresenter.getCSFIndexCapitalFlowsRanking(Integer.valueOf(fParams), 1, 0, 10, flag);
                            } else {
                                if (null == tParams || "".equals(tParams) || null == foParams || "".equals(foParams)) {
                                    contributorPresenter.getCSFIndexCapitalFlowsRanking(Integer.valueOf(fParams), Integer.valueOf(sParams), 0, 10, flag);
                                } else {
                                    contributorPresenter.getCSFIndexCapitalFlowsRanking(Integer.valueOf(fParams), Integer.valueOf(sParams), Integer.valueOf(tParams), Integer.valueOf(foParams), flag);
                                }
                            }
                        }
                    } else if (position == 52) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getCSFIndexCapitalFlowsDetaiil(fParams, flag);
                    } else if (position == 53) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getCSFIndexCapitalFlowsLatest(fParams, flag);
                    } else if (position == 54) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getCSFIndexCapitalFlowsMain(fParams, flag);
                    } else if (position == 55) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        String fourParams = et_four.getText().toString();
                        String fiveParams = et_five.getText().toString();
                        if (fiveParams.isEmpty()) {
                            contributorPresenter.getNewsTagRelevant(fParams, fourParams, Integer.parseInt(sParams), Integer.parseInt(tParams), Constant.szh, flag);
                        } else if (fiveParams.equals(Constant.SZH) || fiveParams.equals(Constant.EN) || fiveParams.equals(Constant.szh) || fiveParams.equals(Constant.en)) {
                            contributorPresenter.getNewsTagRelevant(fParams, fourParams, Integer.parseInt(sParams), Integer.parseInt(tParams), fiveParams, flag);
                        }

                    } else if (position == 56) {
                        String firstParams = et_first.getText().toString();
                        String twoParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        if (tParams.isEmpty()) {
                            contributorPresenter.getNewsTop(Integer.parseInt(firstParams), Integer.parseInt(twoParams), Constant.SZH, flag);
                        } else if (tParams.equals(Constant.SZH) || tParams.equals(Constant.EN) || tParams.equals(Constant.szh) || tParams.equals(Constant.en)) {
                            contributorPresenter.getNewsTop(Integer.parseInt(firstParams), Integer.parseInt(twoParams), tParams, flag);
                        }

                    } else if (position == 57) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        if (null == sParams || "".equals(sParams) || null == fParams || "".equals(fParams) || null == tParams || "".equals(tParams)) {
                            contributorPresenter.getNewsCateGoryStock(0, 10, null, flag);
                        } else {
                            contributorPresenter.getNewsCateGoryStock(Integer.valueOf(fParams), Integer.valueOf(sParams), tParams, flag);
                        }
                    } else if (position == 58) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getNewsDetail(fParams, flag);
                    } else if (position == 59) {
                        contributorPresenter.getAnnounceTypeAll(flag);
                    } else if (position == 60) {
                        contributorPresenter.getAnnounceAffairs(flag);
                    } else if (position == 61) {
                        String fParams = et_first.getText().toString();
                        if (null == fParams || "".equals(fParams)) {
                            contributorPresenter.getStockHotNewsStock(0, flag);
                        } else {
                            contributorPresenter.getStockHotNewsStock(Integer.valueOf(fParams), flag);
                        }
                    } else if (position == 62) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        if (sParams.isEmpty()) {
                            contributorPresenter.getStockRightIssueList(fParams, Constant.SZH, flag);
                        } else if (sParams.equals(Constant.SZH) || sParams.equals(Constant.EN) || sParams.equals(Constant.szh) || sParams.equals(Constant.en)) {
                            contributorPresenter.getStockRightIssueList(fParams, sParams, flag);
                        }

                    } else if (position == 63) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        contributorPresenter.getStockDelist(fParams, sParams, flag);
                    } else if (position == 64) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getMarketIndexRealtimeState(fParams, flag);
                    } else if (position == 65) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String thirdParams = et_third.getText().toString();
                        if (thirdParams.isEmpty()) {
                            contributorPresenter.getSamSearch(fParams, sParams, Constant.SZH, flag);
                        } else if (thirdParams.equals(Constant.SZH) || thirdParams.equals(Constant.EN) || thirdParams.equals(Constant.szh) || thirdParams.equals(Constant.en)) {
                            contributorPresenter.getSamSearch(fParams, sParams, thirdParams, flag);
                        }
                    } else if (position == 66) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        contributorPresenter.getSamStockProductTop(fParams, sParams, flag);
                    } else if (position == 67) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        if (sParams.isEmpty()) {
                            contributorPresenter.getSamSupplyChainRelation(fParams, Constant.SZH, flag);
                        } else if (sParams.equals(Constant.SZH) || sParams.equals(Constant.EN) || sParams.equals(Constant.szh) || sParams.equals(Constant.en)) {
                            contributorPresenter.getSamSupplyChainRelation(fParams, sParams, flag);
                        }

                    } else if (position == 68) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getSamStockProductMacro(fParams, flag);
                    } else if (position == 69) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getSamIndicator(fParams, flag);

                    } else if (position == 70) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        String foParams = et_four.getText().toString();
                        String fiveParams = et_five.getText().toString();
                        if (fiveParams.isEmpty()) {
                            contributorPresenter.getSamIndicatorDetail(fParams, sParams, tParams, foParams, Constant.SZH, flag);
                        } else if (fiveParams.equals(Constant.SZH) || fiveParams.equals(Constant.EN) || fiveParams.equals(Constant.szh) || fiveParams.equals(Constant.en)) {
                            contributorPresenter.getSamIndicatorDetail(fParams, sParams, tParams, foParams, fiveParams, flag);
                        }
                    } else if (position == 71) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getStockHotNewsDetail(fParams, flag);
                    } else if (position == 72) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        if (sParams.isEmpty()) {
                            contributorPresenter.getNeeqBasicInfo(fParams, Constant.szh, flag);
                        } else if (sParams.equals(Constant.SZH) || sParams.equals(Constant.EN) || sParams.equals(Constant.szh) || sParams.equals(Constant.en)) {
                            contributorPresenter.getNeeqBasicInfo(fParams, sParams, flag);
                        }

                    } else if (position == 73) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getNeeqShareHolder(fParams, flag);
                    } else if (position == 74) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        contributorPresenter.getNeeqDailyHistory(fParams, sParams, tParams, flag);
                    } else if (position == 75) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getNeeqItems(fParams, flag);
                    } else if (position == 76) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        String fourParams = et_four.getText().toString();
                        String fiveParams = et_five.getText().toString();
                        contributorPresenter.getNeeqBalacne(fParams, sParams, tParams, fourParams, fiveParams, flag);
                    } else if (position == 77) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        String fourParams = et_four.getText().toString();
                        String fiveParams = et_five.getText().toString();
                        String sixParams = et_six.getText().toString();
                        contributorPresenter.getNeeqIncomes(fParams, sParams, tParams, fourParams, fiveParams, sixParams, flag);
                    } else if (position == 78) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        String fourParams = et_four.getText().toString();
                        String fiveParams = et_five.getText().toString();
                        String sixParams = et_six.getText().toString();
                        contributorPresenter.getNeeqCash(fParams, sParams, tParams, fourParams, fiveParams, sixParams, flag);
                    } else if (position == 79) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getNeeqAdditional(fParams, flag);
                    } else if (position == 80) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getNeeqAdditionalDetail(fParams, flag);
                    }
                    //基金
                    else if (position == 81) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        String foParams = et_four.getText().toString();
                        contributorPresenter.getFundNewsList(fParams, sParams, Integer.valueOf(tParams), Integer.valueOf(foParams), flag);
                    } else if (position == 82) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getFundNewsDetail(fParams, flag);
                    } else if (position == 83) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getFundNetvalueEstimate(fParams, flag);
                    } else if (position == 84) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        contributorPresenter.getFundNetvalueEstimateRanking(fParams, Integer.valueOf(sParams), Integer.valueOf(tParams), flag);
                    } else if (position == 85) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getFundNetvalueNstimateDaily(fParams, flag);
                    } else if (position == 86) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        contributorPresenter.getFundSearch(fParams, Integer.valueOf(sParams), Integer.valueOf(tParams), flag);
                    } else if (position == 87) {
                        //多参数
//                        String fParams = et_first.getText().toString();
                        contributorPresenter.getFundRankings("BBX", "", "", "", "", "", 1, 0, 10, flag);
                    } else if (position == 88) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getFundChangeDaily(fParams, flag);
                    } else if (position == 89) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        contributorPresenter.getFundIndexWeekly(fParams, Integer.valueOf(sParams), Integer.valueOf(tParams), flag);
                    } else if (position == 90) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getFundInvest(fParams, flag);
                    } else if (position == 91) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        contributorPresenter.getFundIndexWeeklyList(fParams, Integer.valueOf(sParams), Integer.valueOf(tParams), flag);
                    } else if (position == 92) {
                        contributorPresenter.getFundIndexCommon(flag);
                    } else if (position == 93) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        contributorPresenter.getFundSelectDiagnose(fParams, sParams, flag);
                    } else if (position == 94) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        contributorPresenter.getFundSelectStockWeight(fParams, sParams, flag);
                    } else if (position == 95) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        contributorPresenter.getFundRecomStockDetail(fParams, sParams, flag);
                    } else if (position == 96) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        contributorPresenter.getFundRecomsNewsDetail(fParams, sParams, flag);
                    } else if (position == 97) {
                        //13个参数,简略成1个参数
                        contributorPresenter.getFundFilter("BBX", "", "", "", "", "", "", "", "", 1, 0, 10, flag);
                    } else if (position == 98) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getFundBasicInfo(fParams, flag);
                    } else if (position == 99) {
                        contributorPresenter.getFundLabelCsftyp(flag);
                    } else if (position == 100) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getFundDetail(fParams, flag);
                    } else if (position == 101) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        String foParams = et_four.getText().toString();
                        String fiParams = et_five.getText().toString();
                        contributorPresenter.getFundNetvalueList(fParams, Integer.valueOf(sParams), Integer.valueOf(tParams), foParams, fiParams, flag);
                    } else if (position == 102) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        contributorPresenter.getFundChangeTrend(fParams, sParams, flag);
                    } else if (position == 103) {
                        //6个参数
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        String fourParams = et_four.getText().toString();
                        String fiveParmas = et_five.getText().toString();
                        String sixParmas = et_six.getText().toString();
                        contributorPresenter.getFundIndicatorRisk(fParams, sParams, tParams, fourParams, fiveParmas, Integer.parseInt(sixParmas), 10, flag);
                    } else if (position == 104) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        String foParams = et_four.getText().toString();
                        contributorPresenter.getFundHistoryDividend(fParams, sParams, tParams, foParams, flag);
                    } else if (position == 105) {
                        //6个参数
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        contributorPresenter.getFundInvestmentCalc(fParams, sParams, "", "", 1, 1000, flag);
                    } else if (position == 106) {
                        //6个参数
                        contributorPresenter.getFundManagerList("000244_OT_FD", "", 0, 10, 1, 1, flag);
                    } else if (position == 107) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getFundManagerDetail(fParams, flag);
                    } else if (position == 108) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getFundFundManager(fParams, flag);
                    } else if (position == 109) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        contributorPresenter.getFundOrgProfile(fParams, sParams, flag);
                    } else if (position == 110) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getFundOrgFundsCate(fParams, flag);
                    } else if (position == 111) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        String foParams = et_four.getText().toString();
                        contributorPresenter.getFundOrgFunds(fParams, sParams, Integer.valueOf(tParams), Integer.valueOf(foParams), flag);
                    } else if (position == 112) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        contributorPresenter.getFundOrgStocks(fParams, sParams, flag);
                    } else if (position == 113) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getFundLabelIndustry(fParams, flag);
                    } else if (position == 114) {
                        contributorPresenter.getFundLabelTheme(flag);
                    } else if (position == 115) {
                        contributorPresenter.getFundLabelStyle(flag);
                    } else if (position == 116) {
                        //6个参数
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        String foParams = et_four.getText().toString();
                        String fiParams = et_five.getText().toString();
                        String siParams = et_six.getText().toString();
                        contributorPresenter.getFundFilterLabel(fParams, sParams, tParams, foParams, Integer.valueOf(fiParams), Integer.valueOf(siParams), flag);
                    } else if (position == 117) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        contributorPresenter.getFundGrade(fParams, sParams, flag);
                    } else if (position == 118) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        contributorPresenter.getFundManagerGrade(fParams, sParams, flag);
                    } else if (position == 119) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getFundAssetSpread(fParams, flag);
                    } else if (position == 120) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getFundAssetIndustry(fParams, flag);
                    } else if (position == 121) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getFundStockWeights(fParams, flag);
                    } else if (position == 122) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getFundBondWeights(fParams, flag);
                    }
                    //资讯
                    else if (position == 123) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getNlpStockRanking(Integer.parseInt(fParams), flag);
                    } else if (position == 124) {
                        contributorPresenter.getNlpIndustryRanking(flag);
                    } else if (position == 125) {
                        contributorPresenter.getNlpFundStockRanking(flag);
                    } else if (position == 126) {
                        contributorPresenter.getNlpFundProductRanking(flag);
                    } else if (position == 127) {
                        contributorPresenter.getNlpIndustryStockRanking(flag);
                    } else if (position == 128) {
                        String fParams = et_first.getText().toString();
                        if (fParams.isEmpty()) {
                            contributorPresenter.getNlpHotNews(Constant.szh, flag);
                        } else if (fParams.equals(Constant.SZH) || fParams.equals(Constant.EN) || fParams.equals(Constant.szh) || fParams.equals(Constant.en)) {
                            contributorPresenter.getNlpHotNews(fParams, flag);
                        }
                    } else if (position == 129) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getNlpHotNewsAnalysisPos(fParams, flag);
                    } else if (position == 130) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getNlpHotNewsAnalysisBus(fParams, flag);
                    } else if (position == 131) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getNlpHotNewsAnalysisSum(fParams, flag);
                    } else if (position == 132) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getNlpHotNewsAnalysisWbl(fParams, flag);
                    } else if (position == 133) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        Integer fourParams = new Integer(et_four.getText().toString());
                        Integer fiveParmas = new Integer(et_five.getText().toString());
                        contributorPresenter.getNlpStockNewsList(fParams, sParams, tParams, fourParams, fiveParmas, flag);
                    } else if (position == 134) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        Integer tParams = new Integer(et_third.getText().toString());
                        Integer fourParams = new Integer(et_four.getText().toString());
                        contributorPresenter.getNlpPeriodNewsStock(fParams, sParams, tParams, fourParams, flag);
                    } else if (position == 135) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        Integer tParams = new Integer(et_third.getText().toString());
                        Integer fourParams = new Integer(et_four.getText().toString());
                        contributorPresenter.getNlpPeriodNewsEmotion(fParams, sParams, tParams, fourParams, flag);
                    } else if (position == 136) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        String tParams = et_third.getText().toString();
                        Integer fourParams = new Integer(et_four.getText().toString());
                        Integer fiveParmas = new Integer(et_five.getText().toString());
                        contributorPresenter.getNlpStockNewsReport(fParams, sParams, tParams, fourParams, fiveParmas, flag);
                    } else if (position == 137) {
                        String fParams = et_first.getText().toString();
                        contributorPresenter.getNlpHotopic(fParams, flag);
                    } else if (position == 138) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        contributorPresenter.getNlpDateTopic(fParams, sParams, flag);
                    } else if (position == 139) {
                        String fParams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        contributorPresenter.getNlpTopicDateStock(fParams, sParams, flag);
                    } else if (position == 140) {
                        String fparams = et_first.getText().toString();
                        String sParams = et_second.getText().toString();
                        if (sParams.isEmpty()) {
                            contributorPresenter.getStockList(fparams, Constant.szh, flag);
                        } else if (sParams.equals(Constant.SZH) || sParams.equals(Constant.EN) || sParams.equals(Constant.szh) || sParams.equals(Constant.en)) {
                            contributorPresenter.getStockList(fparams, sParams, flag);
                        }

                    } else if (position == 141) {
                        String fparams = et_first.getText().toString();
                        String sparams = et_second.getText().toString();
                        String tparams = et_third.getText().toString();
                        contributorPresenter.getSamCodeProduct(fparams, sparams, tparams, flag);
                    } else if (position == 142) {
                        String fparams = et_first.getText().toString();
                        String sparams = et_second.getText().toString();
                        String tparams = et_third.getText().toString();
                        String fourParams = et_four.getText().toString();
                        String fiveParams = et_five.getText().toString();
                        if (fiveParams.isEmpty()) {
                            contributorPresenter.getStockAnnouncementQuery(fparams, sparams, tparams, fourParams, Constant.SZH, flag);
                        } else if (fiveParams.equals(Constant.SZH) || fiveParams.equals(Constant.EN) || fiveParams.equals(Constant.szh) || fiveParams.equals(Constant.en)) {
                            contributorPresenter.getStockAnnouncementQuery(fparams, sparams, tparams, fourParams, fiveParams, flag);
                        }

                    } else if (position == 143) {
                        String fparams = et_first.getText().toString();
                        contributorPresenter.getStockReportCount(fparams, flag);
                    } else if (position == 144) {
                        String fparams = et_first.getText().toString();
                        String sparams = et_second.getText().toString();
                        contributorPresenter.getStockDictCalendar(fparams, Integer.parseInt(sparams), flag);
                    } else if (position == 145) {
                        String fparams = et_first.getText().toString();
                        String sparams = et_second.getText().toString();
                        contributorPresenter.getFundManagerGradeHistory(fparams, sparams, flag);
                    } else if (position == 146) {
                        String fparams = et_first.getText().toString();
                        contributorPresenter.getFundRatings(fparams, flag);
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

                dialog.dismiss();
            }
        });

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        int position = i + 1;
        if (position == 1 || position == 3 || position == 4 || position == 5 || position == 6 || position == 9 || position == 11 || position == 12 || position == 13 || position == 23 || position == 24 || position == 25 || position == 26) {
            texts = new ArrayList<String>();
            texts.add("股票代码");
            showDialog(position, texts);
        } else if (position == 2) {
            texts = new ArrayList<String>();
            texts.add("关键字");
            texts.add("结果条数");
            showDialog(position, texts);
        } else if (position == 7 || position == 8 || position == 10 || position == 59 || position == 60) {
            texts = new ArrayList<String>();
            showDialog(position, texts);
        } else if (position == 56) {
            texts = new ArrayList<String>();
            texts.add("偏移量");
            texts.add("结果条数");
            texts.add("中英文參數");
            showDialog(position, texts);
        } else if (position == 14 || position == 15 || position == 16) {
            texts = new ArrayList<String>();
            texts.add("排序方式");
            texts.add("偏移量");
            texts.add("结果条数");
            showDialog(position, texts);
        } else if (position == 17) {
            texts = new ArrayList<String>();
            texts.add("排序方式");
            texts.add("资金类型");
            texts.add("偏移量");
            texts.add("结果条数");
            showDialog(position, texts);
        } else if (position == 18 || position == 19) {
            texts = new ArrayList<String>();
            texts.add("股票代码");
            texts.add("起始时间");
            texts.add("是否增量");
            showDialog(position, texts);
        } else if (position == 20 || position == 21 || position == 22) {
            texts = new ArrayList<String>();
            texts.add("股票代码");
            texts.add("复权状态");
            texts.add("起始日期");
            texts.add("结束日期");
            showDialog(position, texts);
        } else if (position == 27 || position == 28 || position == 29) {
            texts = new ArrayList<String>();
            texts.add("股票代码");
            texts.add("偏移量");
            texts.add("结果条数");
            showDialog(position, texts);
        } else if (position == 30) {
            texts = new ArrayList<String>();
            texts.add("股票代码");
            texts.add("开始年份");
            texts.add("结束年份");
            texts.add("财务频率");
            texts.add("财务科目代码");
            showDialog(position, texts);
        } else if (position == 31 || position == 32) {
            texts = new ArrayList<String>();
            texts.add("股票代码");
            texts.add("开始年份");
            texts.add("结束年份");
            texts.add("数据类型");
            texts.add("财务频率");
            texts.add("财务科目代码");
            showDialog(position, texts);
        } else if (position == 33) {
            texts = new ArrayList<String>();
            texts.add("财报类型");
            showDialog(position, texts);
        } else if (position == 34 || position == 35) {
            texts = new ArrayList<String>();
            texts.add("大盘指数代码");
            texts.add("排序方式");
            texts.add("偏移量");
            texts.add("结果条数");
            showDialog(position, texts);
        } else if (position == 36 || position == 37 || position == 38) {
            texts = new ArrayList<String>();
            texts.add("大盘指数代码");
            showDialog(position, texts);
        } else if (position == 39 || position == 40) {
            texts = new ArrayList<String>();
            texts.add("大盘指数代码");
            texts.add("起始时间");
            texts.add("是否增量");
            showDialog(position, texts);
        } else if (position == 41 || position == 42 || position == 43) {
            texts = new ArrayList<String>();
            texts.add("大盘指数代码");
            texts.add("起始日期");
            texts.add("结束日期");
            showDialog(position, texts);
        } else if (position == 44) {
            texts = new ArrayList<String>();
            texts.add("指数代码");
            showDialog(position, texts);
        } else if (position == 45) {
            texts = new ArrayList<String>();
            texts.add("数库指数代码");
            texts.add("中英文参数");
            showDialog(position, texts);
        } else if (position == 46 || position == 50 || position == 52 || position == 53 || position == 54) {
            texts = new ArrayList<String>();
            texts.add("数库指数代码");
            showDialog(position, texts);
        } else if (position == 47) {
            texts = new ArrayList<String>();
            texts.add("开始日期");
            texts.add("结束日期");
            texts.add("数库指数代码");
            showDialog(position, texts);
        } else if (position == 48) {
            texts = new ArrayList<String>();
            texts.add("排序类型");
            texts.add("偏移量");
            texts.add("结果条数");
            showDialog(position, texts);
        } else if (position == 49) {
            texts = new ArrayList<String>();
            texts.add("排序方式");
            texts.add("偏移量");
            texts.add("结果条数");
            texts.add("类型");
            showDialog(position, texts);
        } else if (position == 51) {
            texts = new ArrayList<String>();
            texts.add("排序类型");
            texts.add("排序方式");
            texts.add("偏移量");
            texts.add("结果条数");
            showDialog(position, texts);
        } else if (position == 55) {
            texts = new ArrayList<String>();
            texts.add("新闻标签");
            texts.add("偏移量");
            texts.add("结果条数");
            texts.add("查询类型");
            texts.add("中英文参数");
            showDialog(position, texts);
        } else if (position == 57) {
            texts = new ArrayList<String>();
            texts.add("偏移量");
            texts.add("结果条数");
            texts.add("日期");
            showDialog(position, texts);
        } else if (position == 58) {
            texts = new ArrayList<String>();
            texts.add("新闻id");
            showDialog(position, texts);
        } else if (position == 61) {
            texts = new ArrayList<String>();
            texts.add("日期偏移量");
            showDialog(position, texts);
        } else if (position == 62) {
            texts = new ArrayList<String>();
            texts.add("股票代码");
            texts.add("中英文参数");
            showDialog(position, texts);
        } else if (position == 63) {
            texts = new ArrayList<String>();
            texts.add("股票代码");
            texts.add("日期");
            showDialog(position, texts);
        } else if (position == 64) {
            texts = new ArrayList<String>();
            texts.add("大盘指数code");
            showDialog(position, texts);
        } else if (position == 65) {
            texts = new ArrayList<String>();
            texts.add("关键字");
            texts.add("日期");
            texts.add("中英文参数");
            showDialog(position, texts);
        } else if (position == 66) {
            texts = new ArrayList<String>();
            texts.add("股票代码");
            texts.add("查询日期");
            showDialog(position, texts);
        } else if (position == 67) {
            texts = new ArrayList<String>();
            texts.add("samcode");
            texts.add("中英文参数");
            showDialog(position, texts);
        } else if (position == 68) {
            texts = new ArrayList<String>();
            texts.add("数库行业或标准产品编码");
            showDialog(position, texts);
        } else if (position == 69) {
            texts = new ArrayList<String>();
            texts.add("查询关键字");
            showDialog(position, texts);
        } else if (position == 70) {
            texts = new ArrayList<String>();
            texts.add("指标代码");
            texts.add("起始日期");
            texts.add("结束日期");
            texts.add("时间分类");
            texts.add("中英文參數");
            showDialog(position, texts);
        } else if (position == 71) {
            texts = new ArrayList<String>();
            texts.add("ID");
            showDialog(position, texts);
        } else if (position == 72) {
            texts = new ArrayList<String>();
            texts.add("code");
            texts.add("中英文参数");
            showDialog(position, texts);
        } else if (position == 73) {
            texts = new ArrayList<String>();
            texts.add("code");
            showDialog(position, texts);
        } else if (position == 74) {
            texts = new ArrayList<String>();
            texts.add("code");
            texts.add("from");
            texts.add("to");
            showDialog(position, texts);
        } else if (position == 75) {
            texts = new ArrayList<String>();
            texts.add("rpt");
            showDialog(position, texts);
        } else if (position == 76) {
            texts = new ArrayList<String>();
            texts.add("code");
            texts.add("from");
            texts.add("to");
            texts.add("freq");
            texts.add("itemcds");
            showDialog(position, texts);
        } else if (position == 77) {
            texts = new ArrayList<String>();
            texts.add("code");
            texts.add("from");
            texts.add("to");
            texts.add("type");
            texts.add("freq");
            texts.add("itemcds");
            showDialog(position, texts);
        } else if (position == 78) {
            texts = new ArrayList<String>();
            texts.add("code");
            texts.add("from");
            texts.add("to");
            texts.add("type");
            texts.add("freq");
            texts.add("itemcds");
            showDialog(position, texts);
        } else if (position == 79) {
            texts = new ArrayList<String>();
            texts.add("code");
            showDialog(position, texts);
        } else if (position == 80) {
            texts = new ArrayList<String>();
            texts.add("code");
            showDialog(position, texts);
        }
        //基金
        else if (position == 81) {
            texts = new ArrayList<String>();
            texts.add("开始日期");
            texts.add("结束日期");
            texts.add("偏移量");
            texts.add("显示条数");
            showDialog(position, texts);
        } else if (position == 82) {
            texts = new ArrayList<String>();
            texts.add("资讯编号");
            showDialog(position, texts);
        } else if (position == 83) {
            texts = new ArrayList<String>();
            texts.add("基金代码 : 支持最多一次查询10个");
            showDialog(position, texts);
        } else if (position == 84) {
            texts = new ArrayList<String>();
            texts.add("基金类别 : 汉字（非代码）");
            texts.add("偏移量");
            texts.add("显示条数");
            showDialog(position, texts);
        } else if (position == 85) {
            texts = new ArrayList<String>();
            texts.add("基金代码");
            showDialog(position, texts);
        } else if (position == 86) {
            texts = new ArrayList<String>();
            texts.add("查询关键字");
            texts.add("偏移量");
            texts.add("结果条数");
            showDialog(position, texts);
        } else if (position == 87) {
            texts = new ArrayList<String>();
            texts.add("csf基金类型代码");
            texts.add("行业代码");
            texts.add("主题代码");
            texts.add("风格代码");
            texts.add("基金名称");
            texts.add("涨跌幅阶段类型：可选，默认为d");
            texts.add("涨跌幅标识");
            texts.add("偏移量");
            texts.add("显示条数");
            showDialog(position, texts);
        } else if (position == 88) {
            texts = new ArrayList<String>();
            texts.add("基金代码");
            showDialog(position, texts);
        } else if (position == 89) {
            texts = new ArrayList<String>();
            texts.add("领涨类型");
            texts.add("偏移量");
            texts.add("显示条数");
            showDialog(position, texts);
        } else if (position == 90) {
            texts = new ArrayList<String>();
            texts.add("基金代码");
            showDialog(position, texts);
        } else if (position == 91) {
            texts = new ArrayList<String>();
            texts.add("领涨类型");
            texts.add("偏移量");
            texts.add("显示条数");
            showDialog(position, texts);
        } else if (position == 92) {
            texts = new ArrayList<String>();
            texts.add("基金推荐");
            showDialog(position, texts);
        } else if (position == 93) {
            texts = new ArrayList<String>();
            texts.add("基金代码");
            texts.add("基金占比");
            showDialog(position, texts);
        } else if (position == 94) {
            texts = new ArrayList<String>();
            texts.add("基金代码");
            texts.add("基金占比");
            showDialog(position, texts);
        } else if (position == 95) {
            texts = new ArrayList<String>();
            texts.add("基金代码");
            texts.add("推荐日期");
            showDialog(position, texts);
        } else if (position == 96) {
            texts = new ArrayList<String>();
            texts.add("基金代码");
            texts.add("推荐日期");
            showDialog(position, texts);
        } else if (position == 97) {
            texts = new ArrayList<String>();
            texts.add("数库基金类型代码");
            texts.add("行业代码");
            texts.add("主题代码");
            texts.add("风格代码");
            texts.add("基金代码");
            texts.add("基金名称");
            texts.add("基金风险级别");
            texts.add("基金评级");
            texts.add("涨跌幅类型");
            texts.add("涨跌幅标识");
            texts.add("偏移量");
            texts.add("结果条数");
            showDialog(position, texts);
        } else if (position == 98) {
            texts = new ArrayList<String>();
            texts.add("基金代码");
            showDialog(position, texts);
        } else if (position == 99) {
            texts = new ArrayList<String>();
            texts.add("数库基金分类");
            showDialog(position, texts);
        } else if (position == 100) {
            texts = new ArrayList<String>();
            texts.add("基金代码");
            showDialog(position, texts);
        } else if (position == 101) {
            texts = new ArrayList<String>();
            texts.add("基金代码");
            texts.add("偏移量");
            texts.add("结果条数");
            texts.add("起始日期");
            texts.add("终止日期");
            showDialog(position, texts);
        } else if (position == 102) {
            texts = new ArrayList<String>();
            texts.add("基金代码");
            texts.add("时间段类别");
            showDialog(position, texts);
        } else if (position == 103) {
            texts = new ArrayList<String>();
            texts.add("基金代码");
            texts.add("查询起始时间");
            texts.add("查询终止时间");
            texts.add("数据使用年度");
            texts.add("风险指标");
            texts.add("偏移量");
            texts.add("显示条数");
            showDialog(position, texts);
        } else if (position == 104) {
            texts = new ArrayList<String>();
            texts.add("基金代码");
            texts.add("权益登记日");
            texts.add("除息日");
            texts.add("基金红利派发日");
            showDialog(position, texts);
        } else if (position == 105) {
            texts = new ArrayList<String>();
            texts.add("基金代码");
            texts.add("开始时间");
            texts.add("结束时间");
            texts.add("定投频率");
            texts.add("定投日/星期");
            texts.add("定投金额");
            showDialog(position, texts);
        } else if (position == 106) {
            texts = new ArrayList<String>();
            texts.add("基金代码(仅支持单个)");
            texts.add("基金公司id(仅支持单个)");
            texts.add("偏移量");
            texts.add("结果条数");
            texts.add("评级排序");
            texts.add("任期回报率排序");
            showDialog(position, texts);
        } else if (position == 107) {
            texts = new ArrayList<String>();
            texts.add("基金经理编号");
            showDialog(position, texts);
        } else if (position == 108) {
            texts = new ArrayList<String>();
            texts.add("基金代码");
            showDialog(position, texts);
        } else if (position == 109) {
            texts = new ArrayList<String>();
            texts.add("基金代码");
            texts.add("基金公司代码");
            showDialog(position, texts);
        } else if (position == 110) {
            texts = new ArrayList<String>();
            texts.add("基金公司编号");
            showDialog(position, texts);
        } else if (position == 111) {
            texts = new ArrayList<String>();
            texts.add("基金公司编号");
            texts.add("基金类型");
            texts.add("偏移量");
            texts.add("显示条数");
            showDialog(position, texts);
        } else if (position == 112) {
            texts = new ArrayList<String>();
            texts.add("基金代码");
            texts.add("基金公司编号");
            showDialog(position, texts);
        } else if (position == 113) {
            texts = new ArrayList<String>();
            texts.add("行业级别");
            showDialog(position, texts);
        } else if (position == 114) {
            texts = new ArrayList<String>();
            texts.add("主题代码");
            texts.add("主题名称");
            showDialog(position, texts);
        } else if (position == 115) {
            texts = new ArrayList<String>();
            texts.add("风格代码");
            texts.add("风格名称");
            showDialog(position, texts);
        } else if (position == 116) {
            texts = new ArrayList<String>();
            texts.add("行业代码");
            texts.add("主题代码");
            texts.add("风格代码");
            texts.add("基金代码");
            texts.add("偏移量");
            texts.add("显示条数");
            showDialog(position, texts);
        } else if (position == 117) {
            texts = new ArrayList<String>();
            texts.add("基金代码");
            texts.add("查询历史其实月份");
            showDialog(position, texts);
        } else if (position == 118) {
            texts = new ArrayList<String>();
            texts.add("基金代码（仅支持单个）");
            texts.add("基金经理编号（仅支持单个）");
            showDialog(position, texts);
        } else if (position == 119) {
            texts = new ArrayList<String>();
            texts.add("基金代码");
            showDialog(position, texts);
        } else if (position == 120) {
            texts = new ArrayList<String>();
            texts.add("基金代码");
            showDialog(position, texts);
        } else if (position == 121) {
            texts = new ArrayList<String>();
            texts.add("基金代码");
            showDialog(position, texts);
        } else if (position == 122) {
            texts = new ArrayList<String>();
            texts.add("基金代码");
            showDialog(position, texts);
        }
        //资讯
        else if (position == 123) {
            texts = new ArrayList<String>();
            texts.add("返回条数");
            showDialog(position, texts);
        } else if (position == 124 || position == 125 || position == 126 || position == 127) {
            texts = new ArrayList<String>();
            showDialog(position, texts);
        } else if (position == 128) {
            texts = new ArrayList<String>();
            texts.add("中英文參數");
            showDialog(position, texts);
        } else if (position == 129 || position == 130 || position == 131 || position == 132) {
            texts = new ArrayList<String>();
            texts.add("新闻id");
            showDialog(position, texts);
        } else if (position == 133) {
            texts = new ArrayList<String>();
            texts.add("股票代码");
            texts.add("起始日期");
            texts.add("终止日期");
            texts.add("偏移值");
            texts.add("返回条数");
            showDialog(position, texts);
        } else if (position == 134 || position == 135) {
            texts = new ArrayList<String>();
            texts.add("起始日期");
            texts.add("终止日期");
            texts.add("偏移值");
            texts.add("返回条数");
            showDialog(position, texts);
        } else if (position == 136) {
            texts = new ArrayList<String>();
            texts.add("股票代码");
            texts.add("起始日期");
            texts.add("终止日期");
            texts.add("偏移值");
            texts.add("返回条数");
            showDialog(position, texts);
        } else if (position == 137) {
            texts = new ArrayList<String>();
            texts.add("日期");
            showDialog(position, texts);
        } else if (position == 138 || position == 139) {
            texts = new ArrayList<String>();
            texts.add("主题名称");
            texts.add("日期");
            showDialog(position, texts);
        } else if (position == 140) {
            texts = new ArrayList<String>();
            texts.add("市场代码（支持多个查询）");
            texts.add("中英文参数");
            showDialog(position, texts);
        } else if (position == 141) {
            texts = new ArrayList<String>();
            texts.add("samecode");
            texts.add("股票种类");
            texts.add("查询日期 格式：yyyy-mm-dd");
            showDialog(position, texts);
        } else if (position == 142) {
            texts = new ArrayList<String>();
            texts.add("typecode");
            texts.add("typename");
            texts.add("from");
            texts.add("to");
            texts.add("中英文参数");
            showDialog(position, texts);
        } else if (position == 143) {
            texts = new ArrayList<String>();
            texts.add("code");
            showDialog(position, texts);
        } else if (position == 144) {
            texts = new ArrayList<String>();
            texts.add("dt");
            texts.add("limit");
            showDialog(position, texts);
        } else if (position == 145) {
            texts = new ArrayList<String>();
            texts.add("pid");
            texts.add("month");
            showDialog(position, texts);
        } else if (position == 146) {
            texts = new ArrayList<String>();
            texts.add("fcode");
            showDialog(position, texts);
        }
    }
}
