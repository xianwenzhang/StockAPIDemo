package com.csf.csflibrary.presenter;

import android.content.Context;
import android.util.Log;

import com.csf.csflibrary.Tools.Tools;
import com.csf.csflibrary.callback.ContributorView;
import com.csf.csflibrary.constant.Constant;
import com.csf.csflibrary.httpUtils.HttpHeadParams;
import com.csf.csflibrary.httpUtils.LoadCacheResponseLoginouthandler;
import com.csf.csflibrary.httpUtils.LoadDatahandler;
import com.csf.csflibrary.httpUtils.RequstClient;
import com.loopj.android.http.RequestParams;

import java.util.Date;

/**
 *
 */
public class ContributorPresenter {
    private ContributorView contributorView;
    private Context context;
    private String accessKey;
    private String secretKey;

    public ContributorPresenter(ContributorView contributorView, Context context, String accessKey, String secretKey) {
        this.context = context;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.contributorView = contributorView;
        HttpHeadParams.getInstance().setAccessKey(accessKey);
    }

    /**
     * 无网络参数的Get请求
     *
     * @param url
     * @param flag 标识
     */
    private void getCsfAsyncMessage(String url, final String flag) {
        getCsfAsyncMessage(url, null, flag);
    }

    /**
     * 有网络参数的Get请求
     *
     * @param url
     * @param requestParams 网络参数
     * @param flag          标识
     */
    private void getCsfAsyncMessage(String url, RequestParams requestParams, final String flag) {
        RequstClient.get(url, requestParams, new LoadCacheResponseLoginouthandler(context, new LoadDatahandler() {
            @Override
            public void onStart() {
                // TODO Auto-generated method stub
                super.onStart();
                if (contributorView != null) {
                    contributorView.onLoadContributorStart();
                }
            }

            @Override
            public void onSuccess(String data) {
                // TODO Auto-generated method stub
                super.onSuccess(data);
                if (contributorView != null) {
                    contributorView.onLoadContributorSuccess(data, flag);
                }
            }

            @Override
            public void onFailure(String error, String message) {
                // TODO Auto-generated method stub
                super.onFailure(error, message);
                if (contributorView != null) {
                    contributorView.onLoadContributorError(message);
                }
            }

            @Override
            public void onFinish() {
                // TODO Auto-generated method stub
                super.onFinish();
                if (contributorView != null) {
                    contributorView.onLoadContributorComplete();
                }
            }

        }));
    }


    /**
     * 获取数库股票简况和股东股本信息
     *
     * @param code 股票代码
     * @param flag 标识
     */
    public void getStockSummary(String code, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_STOCK_SUMMARY, requestParams, flag);

        } catch (Exception e) {

        }

    }

    /**
     * 股票搜索
     *
     * @param key
     * @param limit
     * @param flag
     */
    public void getStockSearch(String key, Integer limit, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.KEY, key);
            requestParams.put(Constant.limit, limit);
            getCsfAsyncMessage(Constant.API_STOCK_SEARCH, requestParams, flag);

        } catch (Exception e) {

        }

    }

    /**
     * 股票分红转增
     *
     * @param code 股票代码
     * @param flag 标识
     */
    public void getStockBonus(String code, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_STOCK_BONUS, requestParams, flag);

        } catch (Exception e) {

        }
    }

    /**
     * 股票前十大股东信息
     *
     * @param code 股票代码
     * @param flag 标识
     */
    public void getStockHolders(String code, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_STOCK_HOLDERS, requestParams, flag);

        } catch (Exception e) {

        }
    }

    /**
     * 融资融券/沪港通股票判断
     *
     * @param code 股票代码
     * @param flag 标识
     */
    public void getStockCateGoryCheck(String code, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_STOCK_CATEGORY_CHECK, requestParams, flag);

        } catch (Exception e) {

        }
    }

    /**
     * 股票增发实施
     *
     * @param code
     * @param flag
     */
    public void getStockAdditional(String code, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_STOCK_ADDITIONAL, requestParams, flag);

        } catch (Exception e) {

        }
    }

    /**
     * 新股列表
     *
     * @param flag
     */
    public void getStockIpoList(String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            getCsfAsyncMessage(Constant.API_STOCK_IPO_LIST, flag);
        } catch (Exception e) {

        }
    }

    /**
     * 新股日历
     *
     * @param flag 标识
     */
    public void getStockIpoCalendar(String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            getCsfAsyncMessage(Constant.API_STOCK_IPO_CALENDAR, flag);

        } catch (Exception e) {

        }
    }

    /**
     * 新股申购详情
     *
     * @param code 新股代码
     * @param flag 标识
     */
    public void getStockIpoSubscribeDetail(String code, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_STOCK_IPO_SUBSCRIBE_DETAIL, requestParams, flag);

        } catch (Exception e) {

        }
    }

    /**
     * 次新股
     *
     * @param flag 标识
     */
    public void getStockSubnew(String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            getCsfAsyncMessage(Constant.API_STOCK_SUBNEW, requestParams, flag);

        } catch (Exception e) {

        }
    }


    /**
     * 股票实时状态
     *
     * @param code 股票代码
     * @param flag 标识
     */
    public void getStockRealtimeState(String code, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_STOCK_REALTIME_STATE, requestParams, flag);

        } catch (Exception e) {

        }
    }

    /**
     * 股票最新资金流向占比
     *
     * @param code 股票代码
     * @param flag 标识
     */
    public void getStockCapitalFlowsLatest(String code, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_STOCK_CAPITAL_FLOWS_LATEST, requestParams, flag);

        } catch (Exception e) {

        }
    }

    /**
     * 股票近5日主力资金增减仓
     *
     * @param code 股票代码
     * @param flag 标识
     */
    public void getStockCapitalFlowsMain(String code, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_STOCK_CAPITAL_FLOWS_MAIN, requestParams, flag);

        } catch (Exception e) {

        }
    }

    /**
     * 股票成交额榜
     *
     * @param sort   股票代码
     * @param offset 偏移量
     * @param limit  结果条数
     * @param flag   标识
     */
    public void getStockAmountRanking(Integer sort, Integer offset, Integer limit, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.SORT, sort);
            requestParams.put(Constant.offset, offset);
            requestParams.put(Constant.limit, limit);
            getCsfAsyncMessage(Constant.API_STOCK_AMOUNNT_RANKING, requestParams, flag);

        } catch (Exception e) {

        }
    }


    /**
     * 股票涨跌幅榜
     *
     * @param sort   排序方式
     * @param offset 偏移量
     * @param limit  结果条数
     * @param flag   标识
     */
    public void getStockRatioRanking(Integer sort, Integer offset, Integer limit, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.SORT, sort);
            requestParams.put(Constant.offset, offset);
            requestParams.put(Constant.limit, limit);
            getCsfAsyncMessage(Constant.API_STOCK_RATIO_RANKING, requestParams, flag);

        } catch (Exception e) {

        }
    }

    /**
     * 股票换手率榜
     *
     * @param sort   排序方式
     * @param offset 偏移量
     * @param limit  结果条数
     * @param flag   标识
     */
    public void getStockTurnoverRanking(Integer sort, Integer offset, Integer limit, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.SORT, sort);
            requestParams.put(Constant.offset, offset);
            requestParams.put(Constant.limit, limit);
            getCsfAsyncMessage(Constant.API_STOCK_TURNOVER_RANKING, requestParams, flag);

        } catch (Exception e) {

        }
    }

    /**
     * 股票资金流向排行榜
     *
     * @param sort   排序方式 1：升序，2：降序
     * @param type   资金类型 1：流入，2：流出
     * @param offset 偏移量
     * @param limit  结果条数
     * @param flag   标识
     */
    public void getStockCapitalFlowsRanking(Integer sort, Integer type, Integer offset, Integer limit, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.SORT, sort);
            requestParams.put(Constant.TYPE, type);
            requestParams.put(Constant.offset, offset);
            requestParams.put(Constant.limit, limit);
            getCsfAsyncMessage(Constant.API_STOCK_CAPITAL_FLOWS_RANKING, requestParams, flag);

        } catch (Exception e) {

        }
    }

    /**
     * 股票分时数据
     *
     * @param code 股票代码
     * @param dt   起始日期
     * @param incr 是否增量
     * @param flag 标识
     */
    public void getStockTimeShareDaily(String code, String dt, Integer incr, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.DT, dt);
            requestParams.put(Constant.INCR, incr);
            getCsfAsyncMessage(Constant.API_HQ_STOCK_TIME_SHARE_DAILY, requestParams, flag);

        } catch (Exception e) {

        }
    }

    /**
     * 股票5日分时数据
     *
     * @param code 股票代码
     * @param dt   起始日期
     * @param incr 是否增量
     * @param flag 标识
     */
    public void getStockTimeShareWeek(String code, String dt, Integer incr, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.DT, dt);
            requestParams.put(Constant.INCR, incr);
            getCsfAsyncMessage(Constant.API_HQ_STOCK_TIME_SHARE_WEEK, requestParams, flag);

        } catch (Exception e) {

        }
    }

    /**
     * 股票日度行情历史数据
     *
     * @param code     股票代码
     * @param adjusted 复权状态 枚举值：f-前复权，b-后复权, ''-除权
     * @param from     起始日期
     * @param to       结束日期
     * @param flag     标识
     */
    public void getStockPriceDaily(String code, String adjusted, String from, String to, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.ADJUSTED, adjusted);
            requestParams.put(Constant.FROM, from);
            requestParams.put(Constant.TO, to);
            getCsfAsyncMessage(Constant.API_HQ_STOCK_PRICE_DAILY, requestParams, flag);

        } catch (Exception e) {

        }
    }

    /**
     * 股票周度行情历史数据
     *
     * @param code     股票代码
     * @param adjusted 复权状态 枚举值：f-前复权，b-后复权, ''-除权
     * @param from     起始日期
     * @param to       结束日期
     * @param flag     标识
     */
    public void getStockPriceWeekly(String code, String adjusted, String from, String to, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.ADJUSTED, adjusted);
            requestParams.put(Constant.FROM, from);
            requestParams.put(Constant.TO, to);
            getCsfAsyncMessage(Constant.API_HQ_STOCK_PRICE_WEEKLY, requestParams, flag);

        } catch (Exception e) {

        }
    }

    /**
     * 股票月度行情历史数据
     *
     * @param code     股票代码
     * @param adjusted 复权状态 枚举值：f-前复权，b-后复权, ''-除权
     * @param from     起始日期
     * @param to       结束日期
     * @param flag     标识
     */
    public void getStockPriceMonthly(String code, String adjusted, String from, String to, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.ADJUSTED, adjusted);
            requestParams.put(Constant.FROM, from);
            requestParams.put(Constant.TO, to);
            getCsfAsyncMessage(Constant.API_HQ_STOCK_PRICE_MONTHLY, requestParams, flag);

        } catch (Exception e) {

        }
    }

    /**
     * 股票五档委托信息
     *
     * @param code 股票代码
     * @param flag 标识
     */
    public void getStockRealtimeTradeState(String code, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_STOCK_REALTIME_TRADE_STATE, requestParams, flag);

        } catch (Exception e) {

        }
    }


    /**
     * 建议目标价和当前价
     *
     * @param code
     * @param flag
     */
    public void getStockEvaluationSummary(String code, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_STOCK_EVALUATION_SUMMARY, requestParams, flag);

        } catch (Exception e) {

        }
    }

    /**
     * 个股全貌
     *
     * @param code 股票代码
     * @param flag 标识
     */
    public void getStockEvaluationOverView(String code, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_STOCK_EVALUATION_OVERVIEW, requestParams, flag);

        } catch (Exception e) {

        }
    }

    /**
     * 个股标签表
     *
     * @param code
     * @param flag
     */
    public void getStockIdxTag(String code, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_STOCK_IDX_TAG, requestParams, flag);

        } catch (Exception e) {

        }
    }

    /**
     * 获取股票相关新闻
     *
     * @param code   股票代码
     * @param offset 偏移量
     * @param limit  结果条数
     * @param flag   标识
     */
    public void getStockNews(String code, Integer offset, Integer limit, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.offset, offset);
            requestParams.put(Constant.limit, limit);
            getCsfAsyncMessage(Constant.API_STOCK_SNEWS, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 获取股票相关的公告（最近9个月的）
     *
     * @param code   股票代码
     * @param offset 偏移量
     * @param limit  结果条数
     * @param flag   标识
     */
    public void getStockAnnouncement(String code, Integer offset, Integer limit, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.offset, offset);
            requestParams.put(Constant.limit, limit);
            getCsfAsyncMessage(Constant.API_STOCK_ANNOUNCEMENT, requestParams, flag);

        } catch (Exception e) {

        }
    }

    /**
     * 获取股票相关的研报（最近9个月）
     *
     * @param code   股票代码
     * @param offset 偏移量
     * @param limit  结果条数
     * @param flag   标识
     */
    public void getStockReport(String code, Integer offset, Integer limit, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.offset, offset);
            requestParams.put(Constant.limit, limit);
            getCsfAsyncMessage(Constant.API_STOCK_REPORT, requestParams, flag);

        } catch (Exception e) {

        }
    }


    /**
     * 资产负债表
     *
     * @param code
     * @param from
     * @param to
     * @param freq
     * @param itemcds
     * @param flag
     */
    public void getFinanceBalance(String code, String from, String to, String freq, String itemcds, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.FROM, from);
            requestParams.put(Constant.TO, to);
            requestParams.put(Constant.FREQ, freq);
            requestParams.put(Constant.ITEMCDS, itemcds);
            getCsfAsyncMessage(Constant.API_FINANCE_BALANCE, requestParams, flag);

        } catch (Exception e) {

        }
    }

    /**
     * 利润表
     *
     * @param code
     * @param from
     * @param to
     * @param type
     * @param freq
     * @param itemcds
     * @param flag
     */
    public void getFinanceIncomes(String code, String from, String to, String type, String freq, String itemcds, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.FROM, from);
            requestParams.put(Constant.TO, to);
            requestParams.put(Constant.TYPE, type);
            requestParams.put(Constant.FREQ, freq);
            requestParams.put(Constant.ITEMCDS, itemcds);
            getCsfAsyncMessage(Constant.API_FINANCE_INCOMES, requestParams, flag);

        } catch (Exception e) {

        }
    }

    /**
     * 现金流量表
     *
     * @param code
     * @param from
     * @param to
     * @param type
     * @param freq
     * @param itemcds
     * @param flag
     */
    public void getFinanceCash(String code, String from, String to, String type, String freq, String itemcds, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.FROM, from);
            requestParams.put(Constant.TO, to);
            requestParams.put(Constant.TYPE, type);
            requestParams.put(Constant.FREQ, freq);
            requestParams.put(Constant.ITEMCDS, itemcds);
            getCsfAsyncMessage(Constant.API_FINANCE_CASH, requestParams, flag);

        } catch (Exception e) {

        }
    }

    /**
     * 财务科目表
     *
     * @param rpt
     * @param flag
     */
    public void getFinanceItems(String rpt, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.RPT, rpt);
            getCsfAsyncMessage(Constant.API_FINANCE_ITEMS, requestParams, flag);

        } catch (Exception e) {

        }
    }


    /**
     * 成分股涨跌幅榜
     *
     * @param code     必传
     * @param sortType 否 排序方式
     * @param offset   否 偏移量
     * @param limit    否 结果条数
     * @param flag     标识
     */
    public void getMktIndexStkRatioRanking(String code, Integer sortType, Integer offset, Integer limit, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.SORTTYPE, sortType);
            requestParams.put(Constant.offset, offset);
            requestParams.put(Constant.limit, limit);
            getCsfAsyncMessage(Constant.API_MARKET_INDEX_STOCKS_RATIO_RANKING, requestParams, flag);
        } catch (Exception e) {

        }
    }


    /**
     * 成分股换手率榜
     *
     * @param code     大盘指数代码
     * @param sortType 排序方式
     * @param offset   偏移量
     * @param limit    结果条数
     * @param flag     标识
     */
    public void getMktIndexStkTurnoverRanking(String code, Integer sortType, Integer offset, Integer limit, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.SORTTYPE, sortType);
            requestParams.put(Constant.offset, offset);
            requestParams.put(Constant.limit, limit);
            getCsfAsyncMessage(Constant.API_MARKET_INDEX_STOCKS_TURNOVER_RANKING, requestParams, flag);
        } catch (Exception e) {

        }
    }


    /**
     * 最新主力资金流向占比
     *
     * @param code 大盘指数代码
     * @param flag 标识
     */
    public void getMktIndexCapitalFlowsLatest(String code, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_MARKET_INDEX_CAPITAL_FLOWS_LATEST, requestParams, flag);
        } catch (Exception e) {

        }
    }

    /**
     * 近5日主力资金增减仓
     *
     * @param code 大盘指数代码
     * @param flag 标识
     */
    public void getMktIndexCapitalFlowsMain(String code, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_MARKET_INDEX_CAPITAL_FLOWS_MAIN, requestParams, flag);
        } catch (Exception e) {

        }
    }

    /**
     * 实时主力资金流向
     *
     * @param code
     * @param flag
     */
    public void getMktIndexCapitalFlowsRealtime(String code, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_MARKET_INDEX_CAPITAL_FLOWS_REALTIME, requestParams, flag);
        } catch (Exception e) {

        }
    }


    /**
     * 大盘指数当日分时数据
     *
     * @param code 大盘指数代码
     * @param dt   起始时间
     * @param incr 是否增量
     * @param flag 标识
     */
    public void getHQIndexTimeShareDaily(String code, String dt, Integer incr, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.DT, dt);
            requestParams.put(Constant.INCR, incr);
            getCsfAsyncMessage(Constant.API_HQ_INDEX_TIME_SHARE_DAILY, requestParams, flag);
        } catch (Exception e) {

        }
    }


    /**
     * 大盘指数近5日分时数据
     *
     * @param code 大盘指数代码
     * @param dt   起始时间
     * @param incr 是否增量
     * @param flag 标识
     */
    public void getHQIndexTimeShareWeek(String code, String dt, Integer incr, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.DT, dt);
            requestParams.put(Constant.INCR, incr);
            getCsfAsyncMessage(Constant.API_HQ_INDEX_TIME_SHARE_WEEK, requestParams, flag);
        } catch (Exception e) {

        }
    }

    /**
     * 大盘指数日度行情历史数据
     *
     * @param code 大盘指数代码
     * @param from 起始日期
     * @param to   结束日期
     * @param flag 标识
     */
    public void getHQIndexPriceDaily(String code, String from, String to, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.FROM, from);
            requestParams.put(Constant.TO, to);
            getCsfAsyncMessage(Constant.API_HQ_INDEX_PRICE_DAILY, requestParams, flag);
        } catch (Exception e) {

        }
    }


    /**
     * 大盘指数周度行情历史数据
     *
     * @param code 大盘指数代码
     * @param from 起始日期
     * @param to   结束日期
     * @param flag 标识
     */
    public void getHQIndexPriceWeekly(String code, String from, String to, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.FROM, from);
            requestParams.put(Constant.TO, to);
            getCsfAsyncMessage(Constant.API_HQ_INDEX_PRICE_WEEKLY, requestParams, flag);
        } catch (Exception e) {

        }
    }


    /**
     * 大盘指数月度行情历史数据
     *
     * @param code 大盘指数代码
     * @param flag 标识
     */
    public void getHQIndexPriceMonthly(String code, String from, String to, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.FROM, from);
            requestParams.put(Constant.TO, to);
            getCsfAsyncMessage(Constant.API_HQ_INDEX_PRICE_MONTHLY, requestParams, flag);
        } catch (Exception e) {

        }
    }


    /**
     * 指数字典表
     *
     * @param code
     * @param flag
     */
    public void getCSFIndexDict(String code, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_CSF_INDEX_DICT, requestParams, flag);
        } catch (Exception e) {

        }
    }

    /**
     * 指数样本股
     *
     * @param code 指数code
     * @param lang 中英文参数，szh代表返回结果为中文，en代表返回结果为英文
     * @param flag
     */
    public void getCSFIndexStock(String code, String lang, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.LANG, lang);
            getCsfAsyncMessage(Constant.API_CSF_INDEX_STOCK, requestParams, flag);
        } catch (Exception e) {

        }
    }

    /**
     * 数库指数的实时状态
     *
     * @param code 数库指数代码
     * @param flag 标识
     */
    public void getCSFIndexRealtimeState(String code, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_CSF_INDEX_REALTIME_STATE, requestParams, flag);
        } catch (Exception e) {

        }
    }

    /**
     * 指数日度行情历史数据
     *
     * @param from
     * @param to
     * @param code
     * @param flag
     */
    public void getCSFIndexDailyHistory(String from, String to, String code, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FROM, from);
            requestParams.put(Constant.TO, to);
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_CSF_INDEX_DAILY_HISTORY, requestParams, flag);
        } catch (Exception e) {

        }
    }

    /**
     * 数库指数风云榜
     *
     * @param type   0：日收益，1：总收益，2：周收益，3：月收益
     * @param offset 偏移量
     * @param limit  结果条数
     * @param flag   标识
     */
    public void getCSFIndexBollboard(Integer type, Integer offset, Integer limit, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.TYPE, type);
            requestParams.put(Constant.offset, offset);
            requestParams.put(Constant.limit, limit);
            getCsfAsyncMessage(Constant.API_CSF_INDEX_BILLBOARD, requestParams, flag);
        } catch (Exception e) {

        }
    }

    /**
     * 概念指数涨幅榜
     *
     * @param sort
     * @param offset
     * @param limit
     * @param flag
     */
    public void getCSFIndexRatioRanking(Integer sort, Integer offset, Integer limit, Integer type, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.SORT, sort);
            requestParams.put(Constant.offset, offset);
            requestParams.put(Constant.limit, limit);
            requestParams.put(Constant.TYPE, type);
            getCsfAsyncMessage(Constant.API_CSF_INDEX_RATIO_RANKING, requestParams, flag);
        } catch (Exception e) {

        }
    }

    /**
     * 概念指数成份股涨跌幅详情
     *
     * @param code
     * @param flag
     */
    public void getCSFIndexRatioDetail(String code, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_CSF_INDEX_RATIO_DETAIL, requestParams, flag);
        } catch (Exception e) {

        }
    }

    /**
     * 行业/概念资金流向排行榜
     *
     * @param type
     * @param sort
     * @param offset
     * @param limit
     * @param flag
     */
    public void getCSFIndexCapitalFlowsRanking(Integer type, Integer sort, Integer offset, Integer limit, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.TYPE, type);
            requestParams.put(Constant.SORT, sort);
            requestParams.put(Constant.offset, offset);
            requestParams.put(Constant.limit, limit);
            getCsfAsyncMessage(Constant.API_CSF_INDEX_CAPITAL_FLOWS_RANKING, requestParams, flag);
        } catch (Exception e) {

        }
    }

    /**
     * 行业/概念资金流入榜详情
     *
     * @param code
     * @param flag
     */
    public void getCSFIndexCapitalFlowsDetaiil(String code, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_CSF_INDEX_CAPITAL_FLOWS_DETAIL, requestParams, flag);
        } catch (Exception e) {

        }
    }

    /**
     * 数库指数行业/概念资金流向占比
     *
     * @param code 数库指数代码
     * @param flag 标识
     */
    public void getCSFIndexCapitalFlowsLatest(String code, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_CSF_INDEX_CAPITAL_FLOWS_LATEST, requestParams, flag);
        } catch (Exception e) {

        }
    }

    /**
     * 数库指数行业、概念最近5日主力增减仓
     *
     * @param code 数库指数代码
     * @param flag 标识
     */
    public void getCSFIndexCapitalFlowsMain(String code, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_CSF_INDEX_CAPITAL_FLOWS_MAIN, requestParams, flag);
        } catch (Exception e) {

        }
    }

    /**
     * 标签相关新闻
     *
     * @param tag
     * @param type
     * @param offset
     * @param limit
     * @param lang   中英文参数，szh代表返回结果为中文，en代表返回结果为英文
     * @param flag
     */
    public void getNewsTagRelevant(String tag, String type, Integer offset, Integer limit, String lang, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.TAG, tag);
            requestParams.put(Constant.TYPE, type);
            requestParams.put(Constant.offset, offset);
            requestParams.put(Constant.limit, limit);
            requestParams.put(Constant.LANG, lang);
            getCsfAsyncMessage(Constant.API_NEWS_TAG_RELEVANT, requestParams, flag);
        } catch (Exception e) {

        }
    }

    /**
     * 热点新闻
     * @param offset
     * @param limit
     * @param lang 中英文参数，szh代表返回结果为中文，en代表返回结果为英文
     * @param flag
     */
    public void getNewsTop(int offset, int limit, String lang, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.offset, offset);
            requestParams.put(Constant.limit, limit);
            requestParams.put(Constant.LANG, lang);
            getCsfAsyncMessage(Constant.API_NEWS_TOP, requestParams, flag);
        } catch (Exception e) {

        }
    }


    /**
     * 股票类新闻
     *
     * @param offset 偏移量
     * @param limit  结果条数
     * @param flag   标识
     */
    public void getNewsCateGoryStock(Integer offset, Integer limit, String dt, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.offset, offset);
            requestParams.put(Constant.limit, limit);
            if (dt != null)
                requestParams.put(Constant.DT, dt);
            getCsfAsyncMessage(Constant.API_NEWS_CATEGORY_STOCK, requestParams, flag);
        } catch (Exception e) {

        }
    }

    /**
     * 新闻详情
     *
     * @param id   新闻id
     * @param flag 标识
     */
    public void getNewsDetail(String id, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.ID, id);
            getCsfAsyncMessage(Constant.API_NEWS_DETAIL, requestParams, flag);
        } catch (Exception e) {

        }
    }

    /**
     * 公告类型列表
     *
     * @param flag 标识
     */
    public void getAnnounceTypeAll(String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            getCsfAsyncMessage(Constant.API_ANNOUNCE_TYPE_ALL, flag);
        } catch (Exception e) {

        }
    }

    /**
     * 公告类型事件详情列表
     *
     * @param flag 标识
     */
    public void getAnnounceAffairs(String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            getCsfAsyncMessage(Constant.API_ANNOUNCE_AFFAIRS, flag);
        } catch (Exception e) {

        }
    }

    /**
     * 新闻热股
     *
     * @param offset
     * @param flag
     */
    public void getStockHotNewsStock(Integer offset, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.offset, offset);
            getCsfAsyncMessage(Constant.API_STOCK_HOT_NEWS_STOCK, requestParams, flag);
        } catch (Exception e) {

        }
    }

    /**
     * 新闻热股详情
     *
     * @param id
     * @param flag
     */
    public void getStockHotNewsDetail(String id, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.ID, id);
            getCsfAsyncMessage(Constant.API_STOCK_HOT_NEWS_DETAIL, requestParams, flag);
        } catch (Exception e) {

        }
    }

    /**
     * 股票配股
     *
     * @param code
     * @param lang 中英文参数，szh代表返回结果为中文，en代表返回结果为英文
     * @param flag
     */
    public void getStockRightIssueList(String code, String lang, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.LANG, lang);
            getCsfAsyncMessage(Constant.API_STOCK_RIGHTISSUELIST, requestParams, flag);
        } catch (Exception e) {

        }
    }

    /**
     * 个股停牌表
     *
     * @param code 股票代码
     * @param dt   日期
     * @param flag 标记
     */
    public void getStockDelist(String code, String dt, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.DT, dt);
            getCsfAsyncMessage(Constant.API_STOCK_DELIST, requestParams, flag);
        } catch (Exception e) {

        }
    }

    /**
     * 大盘指数实时状态
     *
     * @param code 股票代码
     * @param flag 标记
     */
    public void getMarketIndexRealtimeState(String code, String flag) {
        try {
            //时间戳参数
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_MARKET_INDEX_REALTIME_STATE, requestParams, flag);
        } catch (Exception e) {

        }
    }

    /**
     * SAM产品搜索
     *
     * @param key
     * @param dt
     * @param lang 中英文参数，szh代表返回结果为中文，en代表返回结果为英文
     * @param flag
     */
    public void getSamSearch(String key, String dt, String lang, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.KEY, key);
            requestParams.put(Constant.DT, dt);
            requestParams.put(Constant.LANG, lang);
            getCsfAsyncMessage(Constant.API_SAM_SEARCH, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 数库行业分类（查股票）
     *
     * @param codes
     * @param date
     * @param flag
     */
    public void getSamStockProductTop(String codes, String date, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODES, codes);
            requestParams.put(Constant.DATE, date);
            getCsfAsyncMessage(Constant.API_SAM_STOCK_PRODUCT_TOP, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 数库行业分类（查行业）
     *
     * @param code
     * @param markets
     * @param date
     * @param flag
     */
    public void getSamCodeProduct(String code, String markets, String date, String flag) {
        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.MARKETS, markets);
            requestParams.put(Constant.DATE, date);
            getCsfAsyncMessage(Constant.API_SAM_CODE_PRODUCT, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 产业链
     *
     * @param code
     * @param lang 中英文参数，szh代表返回结果为中文，en代表返回结果为英文
     * @param flag
     */
    public void getSamSupplyChainRelation(String code, String lang, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.LANG, lang);
            getCsfAsyncMessage(Constant.API_SAM_SUPPLY_CHAIN_RELATION, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 数库行业对应宏观指标
     *
     * @param codes
     * @param flag
     */
    public void getSamStockProductMacro(String codes, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODES, codes);
            getCsfAsyncMessage(Constant.API_SAM_PRODUCT_MACRO, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 宏观指标列表
     *
     * @param key
     * @param flag
     */
    public void getSamIndicator(String key, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            if (key != null)
                requestParams.put(Constant.KEY, key);
            getCsfAsyncMessage(Constant.API_SAM_INDICATOR, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 宏观指标详情
     *
     * @param code
     * @param from
     * @param to
     * @param timesort
     * @param lang     中英文参数，szh代表返回结果为中文，en代表返回结果为英文
     * @param flag
     */
    public void getSamIndicatorDetail(String code, String from, String to, String timesort, String lang, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.FROM, from);
            requestParams.put(Constant.TO, to);
            requestParams.put(Constant.TIMESORT, timesort);
            requestParams.put(Constant.LANG, lang);
            getCsfAsyncMessage(Constant.API_SAM_INDICATOR_DETAIL, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 新三板基础信息
     *
     * @param code
     * @param lang 中英文参数，szh代表返回结果为中文，en代表返回结果为英文
     * @param flag
     */
    public void getNeeqBasicInfo(String code, String lang, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.LANG, lang);
            getCsfAsyncMessage(Constant.API_NEEQ_BASIC_INFO, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 新三板股东信息
     *
     * @param code
     * @param flag
     */
    public void getNeeqShareHolder(String code, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_NEEQ_Shareholder, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 新三板日度行情历史数据
     *
     * @param code
     * @param flag
     */
    public void getNeeqDailyHistory(String code, String from, String to, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.FROM, from);
            requestParams.put(Constant.TO, to);
            getCsfAsyncMessage(Constant.API_NEEQ_DAILY_HISTORY, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 新三板财务科目表
     *
     * @param rpt
     * @param flag
     */
    public void getNeeqItems(String rpt, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.RPT, rpt);
            getCsfAsyncMessage(Constant.API_NEEQ_ITEMS, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 新三板资产负债表
     *
     * @param code
     * @param flag
     */
    public void getNeeqBalacne(String code, String from, String to, String freq, String itemcds, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.FROM, from);
            requestParams.put(Constant.TO, to);
            requestParams.put(Constant.FREQ, freq);
            requestParams.put(Constant.ITEMCDS, itemcds);
            getCsfAsyncMessage(Constant.API_NEEQ_BALANCE, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 新三板利润表
     *
     * @param code
     * @param flag
     */
    public void getNeeqIncomes(String code, String from, String to, String type, String freq, String itemcds, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.FROM, from);
            requestParams.put(Constant.TO, to);
            requestParams.put(Constant.TYPE, type);
            requestParams.put(Constant.FREQ, freq);
            requestParams.put(Constant.ITEMCDS, itemcds);
            getCsfAsyncMessage(Constant.API_NEEQ_INCOMES, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 新三板现金流量表
     *
     * @param code
     * @param flag
     */
    public void getNeeqCash(String code, String from, String to, String type, String freq, String itemcds, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            requestParams.put(Constant.FROM, from);
            requestParams.put(Constant.TO, to);
            requestParams.put(Constant.TYPE, type);
            requestParams.put(Constant.FREQ, freq);
            requestParams.put(Constant.ITEMCDS, itemcds);
            getCsfAsyncMessage(Constant.API_NEEQ_CASH, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 新三板增发实施
     *
     * @param code
     * @param flag
     */
    public void getNeeqAdditional(String code, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_NEEQ_ADDITIONAL, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 新三板增发对象明细
     *
     * @param code
     * @param flag
     */
    public void getNeeqAdditionalDetail(String code, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_NEEQ_ADDITIONAL_DETAIL, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金资讯列表
     *
     * @param startDt
     * @param endDt
     * @param offset
     * @param limit
     * @param flag
     */
    public void getFundNewsList(String startDt, String endDt, Integer offset, Integer limit, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.STARTDT, startDt);
            requestParams.put(Constant.ENDDT, endDt);
            requestParams.put(Constant.OFFSET, offset);
            requestParams.put(Constant.LIMIT, limit);
            getCsfAsyncMessage(Constant.API_FUND_NEWS_LIST, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金资讯详情
     *
     * @param id
     * @param flag
     */
    public void getFundNewsDetail(String id, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.ID, id);
            getCsfAsyncMessage(Constant.API_FUND_NEWS_DETAIL, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金实时估值明细
     *
     * @param fcodes
     * @param flag
     */
    public void getFundNetvalueEstimate(String fcodes, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FCODES, fcodes);
            getCsfAsyncMessage(Constant.API_FUND_NETVALUE_ESTIMATE, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金实时估值排名
     *
     * @param ftyp
     * @param offset
     * @param limit
     * @param flag
     */
    public void getFundNetvalueEstimateRanking(String ftyp, Integer offset, Integer limit, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FTYP, ftyp);
            requestParams.put(Constant.OFFSET, offset);
            requestParams.put(Constant.LIMIT, limit);
            getCsfAsyncMessage(Constant.API_FUND_NETVALUE_ESTIMATE_RANKING, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金实时估值走势
     *
     * @param fcode
     * @param flag
     */
    public void getFundNetvalueNstimateDaily(String fcode, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FCODE, fcode);
            getCsfAsyncMessage(Constant.API_FUND_NETVALUE_ESTIMATE_DAILY, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金搜索
     *
     * @param q
     * @param offset
     * @param limit
     * @param flag
     */
    public void getFundSearch(String q, Integer offset, Integer limit, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.Q, q);
            requestParams.put(Constant.OFFSET, offset);
            requestParams.put(Constant.LIMIT, limit);
            getCsfAsyncMessage(Constant.API_FUND_SEARCH, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金收益排行榜
     *
     * @param csftyp
     * @param icode
     * @param theme
     * @param style
     * @param fname
     * @param sortkey
     * @param sort
     * @param offset
     * @param limit
     * @param flag
     */
    public void getFundRankings(String csftyp, String icode, String theme, String style, String fname, String sortkey, Integer sort, Integer offset, Integer limit, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CSFTYP, csftyp);
            requestParams.put(Constant.ICODE, icode);
            requestParams.put(Constant.THEME, theme);
            requestParams.put(Constant.STYLE, style);
            requestParams.put(Constant.FNAME, fname);
            requestParams.put(Constant.SORTKEY, sortkey);
            requestParams.put(Constant.SORT, sort);
            requestParams.put(Constant.OFFSET, offset);
            requestParams.put(Constant.LIMIT, limit);
            getCsfAsyncMessage(Constant.API_FUND_RANKINGS, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金收益对比和排名
     *
     * @param fcode
     * @param flag
     */
    public void getFundChangeDaily(String fcode, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FCODE, fcode);
            getCsfAsyncMessage(Constant.API_FUND_CHANGE_DAILY, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 周领涨板块对应基金
     *
     * @param type
     * @param offset
     * @param limit
     */
    public void getFundIndexWeekly(String type, Integer offset, Integer limit, String flag) {
        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.TYPE, type);
            requestParams.put(Constant.offset, offset);
            requestParams.put(Constant.limit, limit);
            getCsfAsyncMessage(Constant.API_FUND_INDEX_WEEKLY, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金定投收益
     *
     * @param fcode
     * @param flag
     */
    public void getFundInvest(String fcode, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FCODE, fcode);
            getCsfAsyncMessage(Constant.API_FUND_INVEST, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 行业/概念基金推荐
     *
     * @param type
     * @param offset
     * @param limit
     * @param flag
     */
    public void getFundIndexWeeklyList(String type, Integer offset, Integer limit, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.TYPE, type);
            requestParams.put(Constant.OFFSET, offset);
            requestParams.put(Constant.LIMIT, limit);
            getCsfAsyncMessage(Constant.API_FUND_INDEX_WEEKLY_LIST, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金推荐
     *
     * @param flag
     */
    public void getFundIndexCommon(String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            getCsfAsyncMessage(Constant.API_FUND_INDEX_COMMON, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金诊断之收益
     *
     * @param fcode
     * @param uratio
     * @param flag
     */
    public void getFundSelectDiagnose(String fcode, String uratio, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FCODE, fcode);
            requestParams.put(Constant.URATIO, uratio);
            getCsfAsyncMessage(Constant.API_FUND_SELECT_DIAGNOSE, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金诊断之重仓股债
     *
     * @param fcode
     * @param uratio
     * @param flag
     */
    public void getFundSelectStockWeight(String fcode, String uratio, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FCODE, fcode);
            requestParams.put(Constant.URATIO, uratio);
            getCsfAsyncMessage(Constant.API_FUND_SELECT_STOCK_WEIGHT, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金推荐详情之股价
     *
     * @param fcode
     * @param dt
     * @param flag
     */
    public void getFundRecomStockDetail(String fcode, String dt, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FCODE, fcode);
            requestParams.put(Constant.DT, dt);
            getCsfAsyncMessage(Constant.API_FUND_RECOMS_STOCK_DETAIL, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金推荐详情之新闻
     *
     * @param fcode
     * @param dt
     * @param flag
     */
    public void getFundRecomsNewsDetail(String fcode, String dt, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FCODE, fcode);
            requestParams.put(Constant.DT, dt);
            getCsfAsyncMessage(Constant.API_FUND_RECOMS_NEWS_DETAIL, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金筛选
     *
     * @param csftyp
     * @param icode
     * @param theme
     * @param style
     * @param fcode
     * @param fname
     * @param risk
     * @param grade
     * @param sortkey
     * @param sort
     * @param offset
     * @param limit
     * @param flag
     */
    public void getFundFilter(String csftyp, String icode, String theme, String style, String fcode, String fname, String risk, String grade, String sortkey, Integer sort, Integer offset, Integer limit, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CSFTYP, csftyp);
            requestParams.put(Constant.ICODE, icode);
            requestParams.put(Constant.THEME, theme);
            requestParams.put(Constant.STYLE, style);
            requestParams.put(Constant.FCODE, fcode);
            requestParams.put(Constant.FNAME, fname);
            requestParams.put(Constant.RISK, risk);
            requestParams.put(Constant.GRADE, grade);
            requestParams.put(Constant.SORTKEY, sortkey);
            requestParams.put(Constant.SORT, sort);
            requestParams.put(Constant.OFFSET, offset);
            requestParams.put(Constant.LIMIT, limit);
            getCsfAsyncMessage(Constant.API_FUND_FILTER, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金基本信息
     *
     * @param fcode
     * @param flag
     */
    public void getFundBasicInfo(String fcode, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FCODE, fcode);
            getCsfAsyncMessage(Constant.API_FUND_BASIC_INFO, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 数库基金分类
     *
     * @param flag
     */
    public void getFundLabelCsftyp(String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            getCsfAsyncMessage(Constant.API_FUND_LABEL_CSFTYP, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金综合详情
     *
     * @param fcode
     * @param flag
     */
    public void getFundDetail(String fcode, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FCODE, fcode);
            getCsfAsyncMessage(Constant.API_FUND_DETAIL, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金历史净值
     *
     * @param fcode
     * @param offset
     * @param limit
     * @param sdt
     * @param edt
     * @param flag
     */
    public void getFundNetvalueList(String fcode, Integer offset, Integer limit, String sdt, String edt, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FCODE, fcode);
            requestParams.put(Constant.OFFSET, offset);
            requestParams.put(Constant.LIMIT, limit);
            requestParams.put(Constant.SDT, sdt);
            requestParams.put(Constant.EDT, edt);
            getCsfAsyncMessage(Constant.API_FUND_NETVALUE_LIST, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金收益走势
     *
     * @param fcode
     * @param period
     * @param flag
     */
    public void getFundChangeTrend(String fcode, String period, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FCODE, fcode);
            requestParams.put(Constant.PERIOD, period);
            getCsfAsyncMessage(Constant.API_FUND_CHANGE_TREND, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金风险指标
     *
     * @param fcode
     * @param period
     * @param term
     * @param typ
     * @param offset
     * @param limit
     * @param flag
     */
    public void getFundIndicatorRisk(String fcode, String from, String to, String term, String typ, Integer offset, Integer limit, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FCODE, fcode);
            requestParams.put(Constant.FROM, from);
            requestParams.put(Constant.TO, to);
            requestParams.put(Constant.TERM, term);
            requestParams.put(Constant.TYP, typ);
            requestParams.put(Constant.OFFSET, offset);
            requestParams.put(Constant.LIMIT, limit);
            getCsfAsyncMessage(Constant.API_FUND_INDICATOR_RISK, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金历史分红拆分信息
     *
     * @param fcode
     * @param regi
     * @param alys
     * @param paym
     * @param flag
     */
    public void getFundHistoryDividend(String fcode, String regi, String alys, String paym, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FCODE, fcode);
            requestParams.put(Constant.REGI, regi);
            requestParams.put(Constant.ALYS, alys);
            requestParams.put(Constant.PAYM, paym);
            getCsfAsyncMessage(Constant.API_FUND_HISTORY_DIVIDEND, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金定投收益计算
     *
     * @param fcode
     * @param sdt
     * @param edt
     * @param freq
     * @param day
     * @param pmt
     * @param flag
     */
    public void getFundInvestmentCalc(String fcode, String sdt, String edt, String freq, Integer day, Integer pmt, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FCODE, fcode);
            requestParams.put(Constant.SDT, sdt);
            requestParams.put(Constant.EDT, edt);
            requestParams.put(Constant.FREQ, freq);
            requestParams.put(Constant.DAY, day);
            requestParams.put(Constant.PMT, pmt);
            getCsfAsyncMessage(Constant.API_FUND_INVESTMENT_CALC, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金经理列表
     *
     * @param fcode
     * @param orgId
     * @param offset
     * @param limit
     * @param grade
     * @param sort
     * @param flag
     */
    public void getFundManagerList(String fcode, String orgId, Integer offset, Integer limit, Integer grade, Integer sort, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FCODE, fcode);
            requestParams.put(Constant.ORGID, orgId);
            requestParams.put(Constant.OFFSET, offset);
            requestParams.put(Constant.LIMIT, limit);
            requestParams.put(Constant.GRADE, grade);
            requestParams.put(Constant.SORT, sort);
            getCsfAsyncMessage(Constant.API_FUND_MANAGER_LIST, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金经理基本信息
     *
     * @param pid
     * @param flag
     */
    public void getFundManagerDetail(String pid, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.PID, pid);
            getCsfAsyncMessage(Constant.API_FUND_MANAGER_DETAIL, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金历任经理
     *
     * @param fcode
     * @param flag
     */
    public void getFundFundManager(String fcode, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FCODE, fcode);
            getCsfAsyncMessage(Constant.API_FUND_FUND_MANAGER, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金公司基本信息
     *
     * @param fcode
     * @param orgId
     * @param flag
     */
    public void getFundOrgProfile(String fcode, String orgId, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FCODE, fcode);
            requestParams.put(Constant.ORGID, orgId);
            getCsfAsyncMessage(Constant.API_FUND_ORG_PROFILE, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金公司产品类型统计
     *
     * @param orgId
     * @param flag
     */
    public void getFundOrgFundsCate(String orgId, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.ORGID, orgId);
            getCsfAsyncMessage(Constant.API_FUND_ORG_FUNDS_CATE, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金公司类型产品明细
     *
     * @param orgId
     * @param type
     * @param offset
     * @param limit
     * @param flag
     */
    public void getFundOrgFunds(String orgId, String type, Integer offset, Integer limit, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.ORGID, orgId);
            requestParams.put(Constant.TYPE, type);
            requestParams.put(Constant.OFFSET, offset);
            requestParams.put(Constant.LIMIT, limit);
            getCsfAsyncMessage(Constant.API_FUND_ORG_FUNDS, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金公司重仓持股
     *
     * @param fcode
     * @param orgId
     * @param flag
     */
    public void getFundOrgStocks(String fcode, String orgId, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FCODE, fcode);
            requestParams.put(Constant.ORGID, orgId);
            getCsfAsyncMessage(Constant.API_FUND_ORG_STOCKS, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 行业标签列表
     *
     * @param level
     * @param flag
     */
    public void getFundLabelIndustry(String level, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.LEVEL, level);
            getCsfAsyncMessage(Constant.API_FUND_LABEL_INDUSTRY, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 主题标签列表
     *
     * @param flag
     */
    public void getFundLabelTheme(String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            getCsfAsyncMessage(Constant.API_FUND_LABEL_THEME, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 风格标签列表
     *
     * @param flag
     */
    public void getFundLabelStyle(String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            getCsfAsyncMessage(Constant.API_FUND_LABEL_STYLE, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金标签筛选
     *
     * @param icode
     * @param theme
     * @param style
     * @param fcode
     * @param offset
     * @param limit
     * @param flag
     */
    public void getFundFilterLabel(String icode, String theme, String style, String fcode, Integer offset, Integer limit, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.ICODE, icode);
            requestParams.put(Constant.THEME, theme);
            requestParams.put(Constant.STYLE, style);
            requestParams.put(Constant.FCODE, fcode);
            requestParams.put(Constant.OFFSET, offset);
            requestParams.put(Constant.LIMIT, limit);
            getCsfAsyncMessage(Constant.API_FUND_FILTER_LABEL, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金评级
     *
     * @param fcode
     * @param flag
     */
    public void getFundGrade(String fcode, String month, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FCODE, fcode);
            requestParams.put(Constant.MONTH, month);
            getCsfAsyncMessage(Constant.API_FUND_GRADE, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金经理评级
     *
     * @param fcode
     * @param pid
     * @param flag
     */
    public void getFundManagerGrade(String fcode, String pid, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FCODE, fcode);
            requestParams.put(Constant.PID, pid);
            getCsfAsyncMessage(Constant.API_FUND_MANAGER_GRADE, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金资产分布
     *
     * @param fcode
     * @param flag
     */
    public void getFundAssetSpread(String fcode, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FCODE, fcode);
            getCsfAsyncMessage(Constant.API_FUND_ASSET_SPREAD, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金重仓行业
     *
     * @param fcode
     * @param flag
     */
    public void getFundAssetIndustry(String fcode, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FCODE, fcode);
            getCsfAsyncMessage(Constant.API_FUND_ASSET_INDUSTRY, requestParams, flag);
        } catch (Exception e) {
        }
    }


    /**
     * 基金重仓股票
     *
     * @param fcode
     * @param flag
     */
    public void getFundStockWeights(String fcode, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FCODE, fcode);
            getCsfAsyncMessage(Constant.API_FUND_STOCK_WEIGHTS, requestParams, flag);
        } catch (Exception e) {
        }
    }


    /**
     * 基金重仓债券
     *
     * @param fcode
     * @param flag
     */
    public void getFundBondWeights(String fcode, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FCODE, fcode);
            getCsfAsyncMessage(Constant.API_FUND_BOND_WEIGHTS, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 最热股票排行
     *
     * @param limit
     * @param flag
     */
    public void getNlpStockRanking(Integer limit, String flag) {

        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.LIMIT, limit);
            getCsfAsyncMessage(Constant.API_NLP_STOCK_RANKING, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * SAM行业排行
     *
     * @param flag
     */
    public void getNlpIndustryRanking(String flag) {
        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            getCsfAsyncMessage(Constant.API_NLP_INDUSTRY_RANKING, flag);
        } catch (Exception e) {
        }
    }


    /**
     * 基金公司排行
     *
     * @param flag
     */
    public void getNlpFundStockRanking(String flag) {
        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            getCsfAsyncMessage(Constant.API_NLP_FUND_STOCK_RANKING, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金产品排行
     *
     * @param flag
     */
    public void getNlpFundProductRanking(String flag) {
        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            getCsfAsyncMessage(Constant.API_NLP_FUND_PRODUCT_RANKING, flag);
        } catch (Exception e) {
        }
    }

    /**
     * SAM最热股票
     *
     * @param flag
     */
    public void getNlpIndustryStockRanking(String flag) {
        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            getCsfAsyncMessage(Constant.API_NLP_INDUSTRY_STOCK_RANKING, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 实时热点新闻
     *
     * @param lang 中英文参数，szh代表返回结果为中文，en代表返回结果为英文
     * @param flag
     */
    public void getNlpHotNews(String lang, String flag) {
        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.LANG, lang);
            getCsfAsyncMessage(Constant.API_NLP_HOT_NEWS, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 事件情感分析
     *
     * @param id
     * @param flag
     */
    public void getNlpHotNewsAnalysisPos(String id, String flag) {
        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.ID, id);
            getCsfAsyncMessage(Constant.API_NLP_HOT_NEWS_ANALYSIS_POS, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 实体抽取分析
     *
     * @param id
     * @param flag
     */
    public void getNlpHotNewsAnalysisBus(String id, String flag) {
        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.ID, id);
            getCsfAsyncMessage(Constant.API_NLP_HOT_NEWS_ANALYSIS_BUS, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 摘要抽取分析
     *
     * @param id
     * @param flag
     */
    public void getNlpHotNewsAnalysisSum(String id, String flag) {
        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.ID, id);
            getCsfAsyncMessage(Constant.API_NLP_HOT_NEWS_ANALYSIS_SUM, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 产业链图谱分析
     *
     * @param id
     * @param flag
     */
    public void getNlpHotNewsAnalysisWbl(String id, String flag) {
        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.ID, id);
            getCsfAsyncMessage(Constant.API_NLP_HOT_NEWS_ANALYSIS_WBL, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 股票对应新闻信息
     *
     * @param tick
     * @param sdt
     * @param edt
     * @param flag
     */
    public void getNlpStockNewsList(String tick, String sdt, String edt, Integer offset, Integer limit, String flag) {
        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.TICK, tick);
            requestParams.put(Constant.SDT, sdt);
            requestParams.put(Constant.EDT, edt);
            requestParams.put(Constant.OFFSET, offset);
            requestParams.put(Constant.LIMIT, limit);
            getCsfAsyncMessage(Constant.API_NLP_STOCK_NEWS_LIST, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 新闻股票信息
     *
     * @param sdt
     * @param edt
     * @param flag
     */
    public void getNlpPeriodNewsStock(String sdt, String edt, Integer offset, Integer limit, String flag) {
        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.SDT, sdt);
            requestParams.put(Constant.EDT, edt);
            requestParams.put(Constant.OFFSET, offset);
            requestParams.put(Constant.LIMIT, limit);
            getCsfAsyncMessage(Constant.API_NLP_PERIOD_NEWS_STOCK, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 新闻情感信息
     *
     * @param sdt
     * @param edt
     * @param flag
     */
    public void getNlpPeriodNewsEmotion(String sdt, String edt, Integer offset, Integer limit, String flag) {
        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.SDT, sdt);
            requestParams.put(Constant.EDT, edt);
            requestParams.put(Constant.OFFSET, offset);
            requestParams.put(Constant.LIMIT, limit);
            getCsfAsyncMessage(Constant.API_NLP_PERIOD_NEWS_EMOTION, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 研报股票信息
     *
     * @param tick
     * @param sdt
     * @param edt
     * @param flag
     */
    public void getNlpStockNewsReport(String tick, String sdt, String edt, Integer offset, Integer limit, String flag) {
        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.TICK, tick);
            requestParams.put(Constant.SDT, sdt);
            requestParams.put(Constant.EDT, edt);
            requestParams.put(Constant.OFFSET, offset);
            requestParams.put(Constant.LIMIT, limit);
            getCsfAsyncMessage(Constant.API_NLP_STOCK_NEWS_REPORT, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 活跃主题列表
     *
     * @param date
     * @param flag
     */
    public void getNlpHotopic(String date, String flag) {
        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.DATE, date);
            getCsfAsyncMessage(Constant.API_NLP_HOT_TOPIC, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 主题活跃度
     *
     * @param topic
     * @param date
     * @param flag
     */
    public void getNlpDateTopic(String topic, String date, String flag) {
        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.TOPIC, topic);
            requestParams.put(Constant.DATE, date);
            getCsfAsyncMessage(Constant.API_NLP_DATE_TOPIC, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 主题历史相关股票
     *
     * @param topic
     * @param date
     * @param flag
     */
    public void getNlpTopicDateStock(String topic, String date, String flag) {
        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.TOPIC, topic);
            requestParams.put(Constant.DATE, date);
            getCsfAsyncMessage(Constant.API_NLP_TOPIC_DATE_STOCK, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 证券列表
     *
     * @param markets
     * @param lang    中英文参数，szh代表返回结果为中文，en代表返回结果为英文
     * @param flag
     */
    public void getStockList(String markets, String lang, String flag) {
        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.MARKETS, markets);
            requestParams.put(Constant.LANG, lang);
            getCsfAsyncMessage(Constant.API_STOCK_LIST, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 研报三个月目标价
     *
     * @param markets
     * @param flag
     */
    public void getStockReportCount(String code, String flag) {
        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.CODE, code);
            getCsfAsyncMessage(Constant.API_STOCK_REPORT_COUNT, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 交易日历表
     *
     * @param dt
     * @param limit
     * @param flag
     */
    public void getStockDictCalendar(String dt, int limit, String flag) {
        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.DT, dt);
            requestParams.put(Constant.limit, limit);
            getCsfAsyncMessage(Constant.API_STOCK_DICT_CALENDAR, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金经理评级历史
     *
     * @param pid
     * @param month
     * @param flag
     */
    public void getFundManagerGradeHistory(String pid, String month, String flag) {
        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.PID, pid);
            requestParams.put(Constant.MONTH, month);
            getCsfAsyncMessage(Constant.API_FUND_MANAGER_GRADE_HISTORY, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 基金和基金经理最新评级
     *
     * @param pid
     * @param month
     * @param flag
     */
    public void getFundRatings(String fcode, String flag) {
        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            requestParams.put(Constant.FCODE, fcode);
            getCsfAsyncMessage(Constant.API_FUND_RATINGS, requestParams, flag);
        } catch (Exception e) {
        }
    }

    /**
     * 按类型查询股票公告
     *
     * @param typeCode
     * @param typeName
     * @param from
     * @param to
     * @param lang     中英文参数，szh代表返回结果为中文，en代表返回结果为英文
     * @param flag
     */
    public void getStockAnnouncementQuery(String typeCode, String typeName, String from, String to, String lang, String flag) {
        try {
            Long t = new Date().getTime();
            String token = Tools.getToken(accessKey, t, secretKey);
            HttpHeadParams.getInstance().setT(t.toString());
            HttpHeadParams.getInstance().setToken(token);
            RequestParams requestParams = new RequestParams();
            if (typeCode != null && typeCode.length() > 0) {
                requestParams.put(Constant.TYPECODE, typeCode);
            }
            if (typeName != null && typeName.length() > 0) {
                requestParams.put(Constant.TYPENAME, typeName);
            }
            requestParams.put(Constant.FROM, from);
            requestParams.put(Constant.TO, to);
            requestParams.put(Constant.LANG, lang);
            getCsfAsyncMessage(Constant.API_STOCK_ANNOUNCEMENT_QUERY, requestParams, flag);
        } catch (Exception e) {
        }
    }
}
