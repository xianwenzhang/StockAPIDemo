package com.csf.csflibrary.constant;

/**
 * @author jaily.zhang
 * @version V1.3.1
 * @Description 常量类
 * @date 2014-7-22 上午11:15:46
 */
public class Constant {
    //外网
//    public final static String URL = "http://api.ichinascope.com/api";
    //内网
    public final static String URL = "http://192.168.100.34:17081/datasupply";

    //股票ＡＰＩ
    public final static String API_STOCK_SUMMARY = URL + "/stock/summary";
    public final static String API_STOCK_SEARCH = URL + "/stock/search";
    public final static String API_STOCK_BONUS = URL + "/stock/bonus";
    public final static String API_STOCK_HOLDERS = URL + "/stock/holders";
    public final static String API_STOCK_CATEGORY_CHECK = URL + "/stock/category/check";
    public final static String API_STOCK_ADDITIONAL = URL + "/stock/additional";
    public final static String API_STOCK_RIGHTISSUELIST = URL + "/stock/rightissue/list";

    public final static String API_STOCK_IPO_LIST = URL + "/stock/ipo/list";
    public final static String API_STOCK_IPO_CALENDAR = URL + "/stock/ipo/calendar";
    public final static String API_STOCK_IPO_SUBSCRIBE_DETAIL = URL + "/stock/ipo/subscribe/detail";
    public final static String API_STOCK_SUBNEW = URL + "/stock/subnew";

    public final static String API_STOCK_REALTIME_STATE = URL + "/stock/realtime/state";
    public final static String API_STOCK_CAPITAL_FLOWS_LATEST = URL + "/stock/capital/flows/latest";
    public final static String API_STOCK_CAPITAL_FLOWS_MAIN = URL + "/stock/capital/flows/main";
    public final static String API_STOCK_AMOUNNT_RANKING = URL + "/stock/amount/ranking";
    public final static String API_STOCK_RATIO_RANKING = URL + "/stock/ratio/ranking";
    public final static String API_STOCK_TURNOVER_RANKING = URL + "/stock/turnover/ranking";
    public final static String API_STOCK_CAPITAL_FLOWS_RANKING = URL + "/stock/capital/flows/ranking";
    public final static String API_HQ_STOCK_TIME_SHARE_DAILY = URL + "/hq/stock/time/share/daily";
    public final static String API_HQ_STOCK_TIME_SHARE_WEEK = URL + "/hq/stock/time/share/week";
    public final static String API_HQ_STOCK_PRICE_DAILY = URL + "/hq/stock/price/daily";
    public final static String API_HQ_STOCK_PRICE_WEEKLY = URL + "/hq/stock/price/weekly";
    public final static String API_HQ_STOCK_PRICE_MONTHLY = URL + "/hq/stock/price/monthly";
    public final static String API_STOCK_REALTIME_TRADE_STATE = URL + "/stock/realtime/trade/state";

    public final static String API_STOCK_EVALUATION_SUMMARY = URL + "/stock/evaluation/summary";
    public final static String API_STOCK_EVALUATION_OVERVIEW = URL + "/stock/evaluation/overview";
    public final static String API_STOCK_IDX_TAG = URL + "/stock/idx/tag";
    public final static String API_MARKET_INDEX_REALTIME_STATE = URL + "/market/index/realtime/state";

    public final static String API_STOCK_SNEWS = URL + "/stock/news";
    public final static String API_STOCK_ANNOUNCEMENT = URL + "/stock/announcement";
    public final static String API_STOCK_REPORT = URL + "/stock/report";

    public final static String API_FINANCE_BALANCE = URL + "/finance/balance";
    public final static String API_FINANCE_INCOMES = URL + "/finance/incomes";
    public final static String API_FINANCE_CASH = URL + "/finance/cash";
    public final static String API_FINANCE_ITEMS = URL + "/finance/items";

    public final static String API_MARKET_INDEX_STOCKS_RATIO_RANKING = URL + "/market/index/stocks/ratio/ranking";
    public final static String API_MARKET_INDEX_STOCKS_TURNOVER_RANKING = URL + "/market/index/stocks/turnover/ranking";
    public final static String API_MARKET_INDEX_CAPITAL_FLOWS_LATEST = URL + "/market/index/capital/flows/latest";
    public final static String API_MARKET_INDEX_CAPITAL_FLOWS_MAIN = URL + "/market/index/capital/flows/main";
    public final static String API_MARKET_INDEX_CAPITAL_FLOWS_REALTIME = URL + "/market/index/capital/flows/realtime";
    public final static String API_HQ_INDEX_TIME_SHARE_DAILY = URL + "/hq/index/time/share/daily";
    public final static String API_HQ_INDEX_TIME_SHARE_WEEK = URL + "/hq/index/time/share/week";
    public final static String API_HQ_INDEX_PRICE_DAILY = URL + "/hq/index/price/daily";
    public final static String API_HQ_INDEX_PRICE_WEEKLY = URL + "/hq/index/price/weekly";
    public final static String API_HQ_INDEX_PRICE_MONTHLY = URL + "/hq/index/price/monthly";

    public final static String API_CSF_INDEX_DICT = URL + "/csf/index/dict";
    public final static String API_CSF_INDEX_STOCK = URL + "/csf/index/stock";
    public final static String API_CSF_INDEX_REALTIME_STATE = URL + "/csf/index/realtime/state";
    public final static String API_CSF_INDEX_DAILY_HISTORY = URL + "/csf/index/daily/history";
    public final static String API_CSF_INDEX_BILLBOARD = URL + "/csf/index/billboard";
    public final static String API_CSF_INDEX_RATIO_RANKING = URL + "/csf/index/ratio/ranking";
    public final static String API_CSF_INDEX_RATIO_DETAIL = URL + "/csf/index/ratio/detail";
    public final static String API_CSF_INDEX_CAPITAL_FLOWS_RANKING = URL + "/csf/index/capital/flows/ranking";
    public final static String API_CSF_INDEX_CAPITAL_FLOWS_DETAIL = URL + "/csf/index/capital/flows/detail";
    public final static String API_CSF_INDEX_CAPITAL_FLOWS_LATEST = URL + "/csf/index/capital/flows/latest";
    public final static String API_CSF_INDEX_CAPITAL_FLOWS_MAIN = URL + "/csf/index/capital/flows/main";

    public final static String API_NEWS_TAG_RELEVANT = URL + "/news/tag/relevant";
    public final static String API_NEWS_TOP = URL + "/news/top";
    public final static String API_NEWS_CATEGORY_STOCK = URL + "/news/category/stock";
    public final static String API_NEWS_DETAIL = URL + "/news/detail";
    public final static String API_ANNOUNCE_TYPE_ALL = URL + "/announce/type/all";
    public final static String API_ANNOUNCE_AFFAIRS = URL + "/announce/affairs";
    public final static String API_STOCK_HOT_NEWS_STOCK = URL + "/stock/hot/news/stock";
    public final static String API_STOCK_DELIST = URL + "/stock/delist";
    public final static String API_STOCK_HOT_NEWS_DETAIL = URL + "/stock/hot/news/detail";
    public final static String API_STOCK_LIST = URL + "/stock/list";
    public final static String API_STOCK_REPORT_COUNT = URL + "/stock/report/count";
    public final static String API_STOCK_ANNOUNCEMENT_QUERY = URL + "/stock/announcement/query";
    public final static String API_STOCK_DICT_CALENDAR = URL + "/stock/dict/calendar";
    public final static String API_FUND_MANAGER_GRADE_HISTORY = URL + "/fund/manager/grade/history";
    public final static String API_FUND_RATINGS = URL + "/fund/ratings";

    public static String LANG = "lang";
    public static String SZH = "SZH";
    public static String EN = "EN";
    public static String szh = "szh";
    public static String en = "en";
    public static String CODE = "code";
    public static String offset = "offset";
    public static String limit = "limit";
    public static String SORT = "sort";
    public static String TYPE = "type";
    public static String DT = "dt";
    public static String INCR = "incr";
    public static String ADJUSTED = "adjusted";
    public static String FROM = "from";
    public static String TO = "to";
    public static String KEY = "key";
    public static String SORTTYPE = "sortType";
    public static String TAG = "tag";
    public static String ID = "id";
    public static String FREQ = "freq";
    public static String ITEMCDS = "itemcds";
    public static String RPT = "rpt";
    public static String MARKETS = "markets";
    public static String TYPECODE = "typecode";
    public static String TYPENAME = "typename";
    public static String MONTH = "month";

    //特色数据
    public static String API_SAM_SEARCH = URL + "/sam/search";
    public static String API_SAM_STOCK_PRODUCT_TOP = URL + "/sam/stock/product/top";
    public static String API_SAM_SUPPLY_CHAIN_RELATION = URL + "/sam/supply/chain/relation";
    public static String API_SAM_PRODUCT_MACRO = URL + "/sam/product/macro";
    public static String API_SAM_INDICATOR = URL + "/sam/indicator";
    public static String API_SAM_INDICATOR_DETAIL = URL + "/sam/indicator/detail";
    public static String API_SAM_CODE_PRODUCT = URL + "/sam/code/product";
    public static String CODES = "codes";
    public static String DATE = "date";
    public static String TIMESORT = "timesort";


    //新三板
    public static String API_NEEQ_BASIC_INFO = URL + "/neeq/basic/info";
    public static String API_NEEQ_Shareholder = URL + "/neeq/shareholder";
    public static String API_NEEQ_DAILY_HISTORY = URL + "/neeq/daily/history";
    public static String API_NEEQ_ITEMS = URL + "/neeq/items";
    public static String API_NEEQ_BALANCE = URL + "/neeq/balance";
    public static String API_NEEQ_INCOMES = URL + "/neeq/incomes";
    public static String API_NEEQ_CASH = URL + "/neeq/cash";
    public static String API_NEEQ_ADDITIONAL = URL + "/neeq/additional";
    public static String API_NEEQ_ADDITIONAL_DETAIL = URL + "/neeq/additional/detail";

    //基金
    public static String LIMIT = "limit";
    public static String STARTDT = "startDt";
    public static String ENDDT = "endDt";
    public static String OFFSET = "offset";
    public static String FCODES = "fcodes";
    public static String FCODE = "fcode";
    public static String FTYP = "ftyp";
    public static String Q = "q";
    public static String CSFTYP = "csftyp";
    public static String ICODE = "icode";
    public static String THEME = "theme";
    public static String STYLE = "style";
    public static String FNAME = "fname";
    public static String SORTKEY = "sortkey";
    public static String URATIO = "uratio";
    public static String RISK = "risk";
    public static String GRADE = "grade";
    public static String SDT = "sdt";
    public static String EDT = "edt";
    public static String PERIOD = "period";
    public static String TERM = "term";
    public static String REGI = "regi";
    public static String ALYS = "alys";
    public static String PAYM = "paym";
    public static String TYP = "typ";
    public static String DAY = "day";
    public static String PMT = "pmt";
    public static String ORGID = "orgId";
    public static String PID = "pid";
    public static String LEVEL = "level";
    public static String API_FUND_NEWS_LIST = URL + "/fund/news/list";
    public static String API_FUND_NEWS_DETAIL = URL + "/fund/news/detail";
    public static String API_FUND_NETVALUE_ESTIMATE = URL + "/fund/netvalue/estimate";
    public static String API_FUND_NETVALUE_ESTIMATE_RANKING = URL + "/fund/netvalue/estimate/ranking";
    public static String API_FUND_NETVALUE_ESTIMATE_DAILY = URL + "/fund/netvalue/estimate/daily";
    public static String API_FUND_SEARCH = URL + "/fund/search";
    public static String API_FUND_RANKINGS = URL + "/fund/rankings";
    public static String API_FUND_CHANGE_DAILY = URL + "/fund/change/daily";
    public static String API_FUND_INDEX_WEEKLY_LIST = URL + "/fund/index/weekly/list";
    public static String API_FUND_INDEX_COMMON = URL + "/fund/index/common";
    public static String API_FUND_SELECT_DIAGNOSE = URL + "/fund/select/diagnose";
    public static String API_FUND_SELECT_STOCK_WEIGHT = URL + "/fund/select/stock/weight";
    public static String API_FUND_RECOMS_STOCK_DETAIL = URL + "/fund/recoms/stock/detail";
    public static String API_FUND_RECOMS_NEWS_DETAIL = URL + "/fund/recoms/news/detail";
    public static String API_FUND_FILTER = URL + "/fund/filter";
    public static String API_FUND_BASIC_INFO = URL + "/fund/basic/info";
    public static String API_FUND_LABEL_CSFTYP = URL + "/fund/label/csftyp";
    public static String API_FUND_DETAIL = URL + "/fund/detail";
    public static String API_FUND_NETVALUE_LIST = URL + "/fund/netvalue/list";
    public static String API_FUND_CHANGE_TREND = URL + "/fund/change/trend";
    public static String API_FUND_INDICATOR_RISK = URL + "/fund/indicator/risk";
    public static String API_FUND_HISTORY_DIVIDEND = URL + "/fund/history/dividend";
    public static String API_FUND_INVESTMENT_CALC = URL + "/fund/investment/calc";
    public static String API_FUND_MANAGER_LIST = URL + "/fund/manager/list";
    public static String API_FUND_MANAGER_DETAIL = URL + "/fund/manager/detail";
    public static String API_FUND_FUND_MANAGER = URL + "/fund/fund/manager";
    public static String API_FUND_ORG_PROFILE = URL + "/fund/org/profile";
    public static String API_FUND_ORG_FUNDS_CATE = URL + "/fund/org/funds/cate";
    public static String API_FUND_ORG_FUNDS = URL + "/fund/org/funds";
    public static String API_FUND_ORG_STOCKS = URL + "/fund/org/stocks";
    public static String API_FUND_LABEL_INDUSTRY = URL + "/fund/label/industry";
    public static String API_FUND_LABEL_THEME = URL + "/fund/label/theme";
    public static String API_FUND_LABEL_STYLE = URL + "/fund/label/style";
    public static String API_FUND_FILTER_LABEL = URL + "/fund/filter/label";
    public static String API_FUND_GRADE = URL + "/fund/grade";
    public static String API_FUND_MANAGER_GRADE = URL + "/fund/manager/grade";
    public static String API_FUND_ASSET_SPREAD = URL + "/fund/asset/spread";
    public static String API_FUND_ASSET_INDUSTRY = URL + "/fund/asset/industry";
    public static String API_FUND_STOCK_WEIGHTS = URL + "/fund/stock/weights";
    public static String API_FUND_BOND_WEIGHTS = URL + "/fund/bond/weights";
    public static String API_FUND_INDEX_WEEKLY = URL + "/fund/index/weekly";
    public static String API_FUND_INVEST = URL + "/fund/invest";

    //资讯
    public static String TICK = "tick";
    public static String API_NLP_STOCK_RANKING = URL + "/nlp/stock/ranking";
    public static String API_NLP_INDUSTRY_RANKING = URL + "/nlp/industry/ranking";
    public static String API_NLP_FUND_STOCK_RANKING = URL + "/nlp/fund/stock/ranking";
    public static String API_NLP_FUND_PRODUCT_RANKING = URL + "/nlp/fund/product/ranking";
    public static String API_NLP_INDUSTRY_STOCK_RANKING = URL + "/nlp/industry/stock/ranking";
    public static String API_NLP_HOT_NEWS = URL + "/nlp/hot/news";
    public static String API_NLP_HOT_NEWS_ANALYSIS_POS = URL + "/nlp/hot/news/analysis/pos";
    public static String API_NLP_HOT_NEWS_ANALYSIS_BUS = URL + "/nlp/hot/news/analysis/bus";
    public static String API_NLP_HOT_NEWS_ANALYSIS_SUM = URL + "/nlp/hot/news/analysis/sum";
    public static String API_NLP_HOT_NEWS_ANALYSIS_WBL = URL + "/nlp/hot/news/analysis/wbl";
    public static String API_NLP_STOCK_NEWS_LIST = URL + "/nlp/stock/news/list";
    public static String API_NLP_PERIOD_NEWS_STOCK = URL + "/nlp/period/news/stock";
    public static String API_NLP_PERIOD_NEWS_EMOTION = URL + "/nlp/period/news/emotion";
    public static String API_NLP_STOCK_NEWS_REPORT = URL + "/nlp/stock/news/report";
    public static String API_NLP_HOT_TOPIC = URL + "/nlp/hot/topic";
    public static String API_NLP_DATE_TOPIC = URL + "/nlp/date/topic";
    public static String TOPIC = "topic";
    public static String API_NLP_TOPIC_DATE_STOCK = URL + "/nlp/topic/date/stock";
}
