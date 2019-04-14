// Compiled by ClojureScript 1.10.439 {:target :nodejs}
goog.provide('cljs.repl');
goog.require('cljs.core');
goog.require('cljs.spec.alpha');
cljs.repl.print_doc = (function cljs$repl$print_doc(p__33080){
var map__33081 = p__33080;
var map__33081__$1 = (((((!((map__33081 == null))))?(((((map__33081.cljs$lang$protocol_mask$partition0$ & (64))) || ((cljs.core.PROTOCOL_SENTINEL === map__33081.cljs$core$ISeq$))))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__33081):map__33081);
var m = map__33081__$1;
var n = cljs.core.get.call(null,map__33081__$1,new cljs.core.Keyword(null,"ns","ns",441598760));
var nm = cljs.core.get.call(null,map__33081__$1,new cljs.core.Keyword(null,"name","name",1843675177));
cljs.core.println.call(null,"-------------------------");

cljs.core.println.call(null,(function (){var or__4047__auto__ = new cljs.core.Keyword(null,"spec","spec",347520401).cljs$core$IFn$_invoke$arity$1(m);
if(cljs.core.truth_(or__4047__auto__)){
return or__4047__auto__;
} else {
return [cljs.core.str.cljs$core$IFn$_invoke$arity$1((function (){var temp__5457__auto__ = new cljs.core.Keyword(null,"ns","ns",441598760).cljs$core$IFn$_invoke$arity$1(m);
if(cljs.core.truth_(temp__5457__auto__)){
var ns = temp__5457__auto__;
return [cljs.core.str.cljs$core$IFn$_invoke$arity$1(ns),"/"].join('');
} else {
return null;
}
})()),cljs.core.str.cljs$core$IFn$_invoke$arity$1(new cljs.core.Keyword(null,"name","name",1843675177).cljs$core$IFn$_invoke$arity$1(m))].join('');
}
})());

if(cljs.core.truth_(new cljs.core.Keyword(null,"protocol","protocol",652470118).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"Protocol");
} else {
}

if(cljs.core.truth_(new cljs.core.Keyword(null,"forms","forms",2045992350).cljs$core$IFn$_invoke$arity$1(m))){
var seq__33083_33105 = cljs.core.seq.call(null,new cljs.core.Keyword(null,"forms","forms",2045992350).cljs$core$IFn$_invoke$arity$1(m));
var chunk__33084_33106 = null;
var count__33085_33107 = (0);
var i__33086_33108 = (0);
while(true){
if((i__33086_33108 < count__33085_33107)){
var f_33109 = cljs.core._nth.call(null,chunk__33084_33106,i__33086_33108);
cljs.core.println.call(null,"  ",f_33109);


var G__33110 = seq__33083_33105;
var G__33111 = chunk__33084_33106;
var G__33112 = count__33085_33107;
var G__33113 = (i__33086_33108 + (1));
seq__33083_33105 = G__33110;
chunk__33084_33106 = G__33111;
count__33085_33107 = G__33112;
i__33086_33108 = G__33113;
continue;
} else {
var temp__5457__auto___33114 = cljs.core.seq.call(null,seq__33083_33105);
if(temp__5457__auto___33114){
var seq__33083_33115__$1 = temp__5457__auto___33114;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__33083_33115__$1)){
var c__4461__auto___33116 = cljs.core.chunk_first.call(null,seq__33083_33115__$1);
var G__33117 = cljs.core.chunk_rest.call(null,seq__33083_33115__$1);
var G__33118 = c__4461__auto___33116;
var G__33119 = cljs.core.count.call(null,c__4461__auto___33116);
var G__33120 = (0);
seq__33083_33105 = G__33117;
chunk__33084_33106 = G__33118;
count__33085_33107 = G__33119;
i__33086_33108 = G__33120;
continue;
} else {
var f_33121 = cljs.core.first.call(null,seq__33083_33115__$1);
cljs.core.println.call(null,"  ",f_33121);


var G__33122 = cljs.core.next.call(null,seq__33083_33115__$1);
var G__33123 = null;
var G__33124 = (0);
var G__33125 = (0);
seq__33083_33105 = G__33122;
chunk__33084_33106 = G__33123;
count__33085_33107 = G__33124;
i__33086_33108 = G__33125;
continue;
}
} else {
}
}
break;
}
} else {
if(cljs.core.truth_(new cljs.core.Keyword(null,"arglists","arglists",1661989754).cljs$core$IFn$_invoke$arity$1(m))){
var arglists_33126 = new cljs.core.Keyword(null,"arglists","arglists",1661989754).cljs$core$IFn$_invoke$arity$1(m);
if(cljs.core.truth_((function (){var or__4047__auto__ = new cljs.core.Keyword(null,"macro","macro",-867863404).cljs$core$IFn$_invoke$arity$1(m);
if(cljs.core.truth_(or__4047__auto__)){
return or__4047__auto__;
} else {
return new cljs.core.Keyword(null,"repl-special-function","repl-special-function",1262603725).cljs$core$IFn$_invoke$arity$1(m);
}
})())){
cljs.core.prn.call(null,arglists_33126);
} else {
cljs.core.prn.call(null,((cljs.core._EQ_.call(null,new cljs.core.Symbol(null,"quote","quote",1377916282,null),cljs.core.first.call(null,arglists_33126)))?cljs.core.second.call(null,arglists_33126):arglists_33126));
}
} else {
}
}

if(cljs.core.truth_(new cljs.core.Keyword(null,"special-form","special-form",-1326536374).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"Special Form");

cljs.core.println.call(null," ",new cljs.core.Keyword(null,"doc","doc",1913296891).cljs$core$IFn$_invoke$arity$1(m));

if(cljs.core.contains_QMARK_.call(null,m,new cljs.core.Keyword(null,"url","url",276297046))){
if(cljs.core.truth_(new cljs.core.Keyword(null,"url","url",276297046).cljs$core$IFn$_invoke$arity$1(m))){
return cljs.core.println.call(null,["\n  Please see http://clojure.org/",cljs.core.str.cljs$core$IFn$_invoke$arity$1(new cljs.core.Keyword(null,"url","url",276297046).cljs$core$IFn$_invoke$arity$1(m))].join(''));
} else {
return null;
}
} else {
return cljs.core.println.call(null,["\n  Please see http://clojure.org/special_forms#",cljs.core.str.cljs$core$IFn$_invoke$arity$1(new cljs.core.Keyword(null,"name","name",1843675177).cljs$core$IFn$_invoke$arity$1(m))].join(''));
}
} else {
if(cljs.core.truth_(new cljs.core.Keyword(null,"macro","macro",-867863404).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"Macro");
} else {
}

if(cljs.core.truth_(new cljs.core.Keyword(null,"spec","spec",347520401).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"Spec");
} else {
}

if(cljs.core.truth_(new cljs.core.Keyword(null,"repl-special-function","repl-special-function",1262603725).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"REPL Special Function");
} else {
}

cljs.core.println.call(null," ",new cljs.core.Keyword(null,"doc","doc",1913296891).cljs$core$IFn$_invoke$arity$1(m));

if(cljs.core.truth_(new cljs.core.Keyword(null,"protocol","protocol",652470118).cljs$core$IFn$_invoke$arity$1(m))){
var seq__33087_33127 = cljs.core.seq.call(null,new cljs.core.Keyword(null,"methods","methods",453930866).cljs$core$IFn$_invoke$arity$1(m));
var chunk__33088_33128 = null;
var count__33089_33129 = (0);
var i__33090_33130 = (0);
while(true){
if((i__33090_33130 < count__33089_33129)){
var vec__33091_33131 = cljs.core._nth.call(null,chunk__33088_33128,i__33090_33130);
var name_33132 = cljs.core.nth.call(null,vec__33091_33131,(0),null);
var map__33094_33133 = cljs.core.nth.call(null,vec__33091_33131,(1),null);
var map__33094_33134__$1 = (((((!((map__33094_33133 == null))))?(((((map__33094_33133.cljs$lang$protocol_mask$partition0$ & (64))) || ((cljs.core.PROTOCOL_SENTINEL === map__33094_33133.cljs$core$ISeq$))))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__33094_33133):map__33094_33133);
var doc_33135 = cljs.core.get.call(null,map__33094_33134__$1,new cljs.core.Keyword(null,"doc","doc",1913296891));
var arglists_33136 = cljs.core.get.call(null,map__33094_33134__$1,new cljs.core.Keyword(null,"arglists","arglists",1661989754));
cljs.core.println.call(null);

cljs.core.println.call(null," ",name_33132);

cljs.core.println.call(null," ",arglists_33136);

if(cljs.core.truth_(doc_33135)){
cljs.core.println.call(null," ",doc_33135);
} else {
}


var G__33137 = seq__33087_33127;
var G__33138 = chunk__33088_33128;
var G__33139 = count__33089_33129;
var G__33140 = (i__33090_33130 + (1));
seq__33087_33127 = G__33137;
chunk__33088_33128 = G__33138;
count__33089_33129 = G__33139;
i__33090_33130 = G__33140;
continue;
} else {
var temp__5457__auto___33141 = cljs.core.seq.call(null,seq__33087_33127);
if(temp__5457__auto___33141){
var seq__33087_33142__$1 = temp__5457__auto___33141;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__33087_33142__$1)){
var c__4461__auto___33143 = cljs.core.chunk_first.call(null,seq__33087_33142__$1);
var G__33144 = cljs.core.chunk_rest.call(null,seq__33087_33142__$1);
var G__33145 = c__4461__auto___33143;
var G__33146 = cljs.core.count.call(null,c__4461__auto___33143);
var G__33147 = (0);
seq__33087_33127 = G__33144;
chunk__33088_33128 = G__33145;
count__33089_33129 = G__33146;
i__33090_33130 = G__33147;
continue;
} else {
var vec__33096_33148 = cljs.core.first.call(null,seq__33087_33142__$1);
var name_33149 = cljs.core.nth.call(null,vec__33096_33148,(0),null);
var map__33099_33150 = cljs.core.nth.call(null,vec__33096_33148,(1),null);
var map__33099_33151__$1 = (((((!((map__33099_33150 == null))))?(((((map__33099_33150.cljs$lang$protocol_mask$partition0$ & (64))) || ((cljs.core.PROTOCOL_SENTINEL === map__33099_33150.cljs$core$ISeq$))))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__33099_33150):map__33099_33150);
var doc_33152 = cljs.core.get.call(null,map__33099_33151__$1,new cljs.core.Keyword(null,"doc","doc",1913296891));
var arglists_33153 = cljs.core.get.call(null,map__33099_33151__$1,new cljs.core.Keyword(null,"arglists","arglists",1661989754));
cljs.core.println.call(null);

cljs.core.println.call(null," ",name_33149);

cljs.core.println.call(null," ",arglists_33153);

if(cljs.core.truth_(doc_33152)){
cljs.core.println.call(null," ",doc_33152);
} else {
}


var G__33154 = cljs.core.next.call(null,seq__33087_33142__$1);
var G__33155 = null;
var G__33156 = (0);
var G__33157 = (0);
seq__33087_33127 = G__33154;
chunk__33088_33128 = G__33155;
count__33089_33129 = G__33156;
i__33090_33130 = G__33157;
continue;
}
} else {
}
}
break;
}
} else {
}

if(cljs.core.truth_(n)){
var temp__5457__auto__ = cljs.spec.alpha.get_spec.call(null,cljs.core.symbol.call(null,cljs.core.str.cljs$core$IFn$_invoke$arity$1(cljs.core.ns_name.call(null,n)),cljs.core.name.call(null,nm)));
if(cljs.core.truth_(temp__5457__auto__)){
var fnspec = temp__5457__auto__;
cljs.core.print.call(null,"Spec");

var seq__33101 = cljs.core.seq.call(null,new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"args","args",1315556576),new cljs.core.Keyword(null,"ret","ret",-468222814),new cljs.core.Keyword(null,"fn","fn",-1175266204)], null));
var chunk__33102 = null;
var count__33103 = (0);
var i__33104 = (0);
while(true){
if((i__33104 < count__33103)){
var role = cljs.core._nth.call(null,chunk__33102,i__33104);
var temp__5457__auto___33158__$1 = cljs.core.get.call(null,fnspec,role);
if(cljs.core.truth_(temp__5457__auto___33158__$1)){
var spec_33159 = temp__5457__auto___33158__$1;
cljs.core.print.call(null,["\n ",cljs.core.str.cljs$core$IFn$_invoke$arity$1(cljs.core.name.call(null,role)),":"].join(''),cljs.spec.alpha.describe.call(null,spec_33159));
} else {
}


var G__33160 = seq__33101;
var G__33161 = chunk__33102;
var G__33162 = count__33103;
var G__33163 = (i__33104 + (1));
seq__33101 = G__33160;
chunk__33102 = G__33161;
count__33103 = G__33162;
i__33104 = G__33163;
continue;
} else {
var temp__5457__auto____$1 = cljs.core.seq.call(null,seq__33101);
if(temp__5457__auto____$1){
var seq__33101__$1 = temp__5457__auto____$1;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__33101__$1)){
var c__4461__auto__ = cljs.core.chunk_first.call(null,seq__33101__$1);
var G__33164 = cljs.core.chunk_rest.call(null,seq__33101__$1);
var G__33165 = c__4461__auto__;
var G__33166 = cljs.core.count.call(null,c__4461__auto__);
var G__33167 = (0);
seq__33101 = G__33164;
chunk__33102 = G__33165;
count__33103 = G__33166;
i__33104 = G__33167;
continue;
} else {
var role = cljs.core.first.call(null,seq__33101__$1);
var temp__5457__auto___33168__$2 = cljs.core.get.call(null,fnspec,role);
if(cljs.core.truth_(temp__5457__auto___33168__$2)){
var spec_33169 = temp__5457__auto___33168__$2;
cljs.core.print.call(null,["\n ",cljs.core.str.cljs$core$IFn$_invoke$arity$1(cljs.core.name.call(null,role)),":"].join(''),cljs.spec.alpha.describe.call(null,spec_33169));
} else {
}


var G__33170 = cljs.core.next.call(null,seq__33101__$1);
var G__33171 = null;
var G__33172 = (0);
var G__33173 = (0);
seq__33101 = G__33170;
chunk__33102 = G__33171;
count__33103 = G__33172;
i__33104 = G__33173;
continue;
}
} else {
return null;
}
}
break;
}
} else {
return null;
}
} else {
return null;
}
}
});

//# sourceMappingURL=repl.js.map
