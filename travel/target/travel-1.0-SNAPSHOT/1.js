//获取cid的参数值
var cid = getParameter("cid");
//获取rname的参数值
var rname = getParameter("rname");
//判断rname如果不为null或者""
if (rname) {
    //url解码
    rname = window.decodeURIComponent(rname);
}
alert(cid);     // 5
alert(rname);   // 兵马俑