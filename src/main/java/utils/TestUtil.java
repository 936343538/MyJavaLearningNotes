package utils;

import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.lang.WeightRandom;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author hongzf
 * @since 2021/6/13
 */
public class TestUtil {

    private static List<String> randomTextList;

    /**
     * 获取随机文字
     *
     * @return 随机文字
     */
    public static String randomText(int textLength) {
        if (IterUtil.isEmpty(randomTextList)) {
            synchronized (TestUtil.class) {
                if (IterUtil.isEmpty(randomTextList)) {
                    String randomText = "困境之中，饱含机遇。执着于理想，纯粹于当下。若要梦想实现，先从梦中醒来。欲戴皇冠，必承其重。成功的秘诀在于对目标的执着追求。风乍起，合当奋意向人生。听闻少年二字，应与平庸相斥。纵有疾风起，人生不言弃。没有人，会把你所有缺点包容。每天进步一点点，希望的火苗不熄灭。希望你像星辰，善良，明亮。不是井里没有水，而是挖的不够。与其在风雨中逃避，不如在雷电中舞蹈，即便淋得透湿，也是领略生命的快意。只有回不了的过去，没有到不了的明天。人生太苦，多加点糖。把脸一直向着阳光，这样就不会见到阴影。要做向日葵，种在阳光的掌心里。早晨给自己一个微笑，种下一天阳光。万事都要全力以赴，包括开心。像记得回家的路一样，记得理想和远方。不迷茫，不依附，有自尊，这就是你的底气。无论明日有多落魄，至少今天没有蹉跎。现在就出发吧，总有一个落脚的地方和一个温柔的人在未来等你。有一个人任何时候都不会背弃你，这个人就是你自己。尊重现在，善待自己，往事不记后事不提。少年的梦，不应止于心动，更要付诸行动。不一定每天都很好，但每天都会有些小美好在等你。努力就是为了远离你不喜欢的人。既然做不了富二代，那就自己努力做富一代吧。天赋决定上限，努力决定下限。发奋努力，只是为了证明，我足以与你相配。一做出成绩来，全世界都会和颜悦色。没有自觉和自律，就没有真正的自由和自在。我当然不会去摘月亮，我要它向我奔来。别在最好的年纪，辜负最好的自己。努力一点吧，为了能走更好的路，遇见更优秀的人。望自己成熟稳重善良填满优秀。生活百般滋味，你要笑着面对。努力过得充实，别留给自己难过的机会。你必须拼尽全力，才有资格说自己运气不好。生活再平凡，也是限量版，别轻看自己。只要你肯去努力，你就是幸运的。少点以为，多点作为。同时风华正茂，何甘他人之后。痛苦不是失败，而是你本可以。温柔半两，从容一生。保持热爱，奔赴山海。知命不惧，日日自新。一切尽力，万事胜意。与自己成为朋友，才能听见万物回响。星星发亮，是为了让每一个人有一天都能找到属于自己的星星。书要好好读，喜欢的人要好好争取。跟这个世界交手的许多年来，你是否，光彩依旧，兴趣盎然。星星应该哈哈大笑，反正宇宙是个偏僻的地方。在一切破旧褪色中，请你永远闪烁。在路上，永远年轻，永远热泪盈眶。接受孤独，保持清醒，好好爱自己。世事你曾抗争，成败不必在你——失败可以，甘心不可以。别人给你的期望都是别人的，你自己给你什么期望才最重要。太阳依旧会升起，哪怕照亮的只是废墟。你不要太在意别人怎么看你，你做好自己，大家自然就喜欢你。世上鲜花会盛开，壮丽不朽的事会接踵而来。要看到人生微弱的灯火，你必须走进最深的黑暗。所有的苦难和背负尽头都是行云流水般的此时光阴。当你快挺不住的时候，磨难也挺不住了。再小的努力乘以365都很明显。不能说自己平平无奇，我们都是独一无二。种树的最佳时间是15年前，仅次于它的时间是现在。被云层遮挡起来的星星也在努力发光。当你觉得晚的时候，恰恰是最早的时候。希望每个人，都拥有把热爱放在心底，去为它披荆斩棘清理掉所有障碍，再铺上一条红毯，放上路途中偶然发现的美丽花朵，再去好好迎接它的勇气。往前走、往前看，哪怕前途一片迷惘，哪怕只是凭着惯性继续往前走。总有一天，会在自己漫长的脚印中找到方向。只是大概需要一点耐心。我觉得当下的每件小事都特别重要。充好电，才能做更好的自己。在所有人都放弃你的时候，你要记得，几十亿的细胞，都在为你而活。他们试图埋掉你，但你要知道你是种子。不要停止奔跑，不要回顾来路，来路无可眷恋，值得期待的只有前方。努力是会上瘾的，特别是尝到甜头之后。人生最低谷的时候那只是在缓冲，是达到最高点必须经过的地方。你被安稳地爱着呢，应该有做任何事的勇气。煎和熬都是变美味的方式，加油也是。每个优秀的人都有一段沉默的时光，那段时光是付出了很多努力，却得不到结果的日子，我们把它叫做扎根。如果你找不到一个坚持下去的理由，那就找一个重新开始的理由。你所热爱的东西，有一天会反过来拥抱你。且挨过三冬四夏，暂受些此痛苦，雪尽后再看梅花。内心仰望理想的人，都在低头干活。害怕攀登高峰的人，永远在山下徘徊。世上没有捷径，通向成功的路都需要翻山越岭。把努力当成你的一种习惯，而不是一时的热血。只有到了漆黑的夜晚，才能闪耀出夺目的星光。千万别丧，你要知道无论经历什么都是在成长。下了决心要做的事，要保持不动声色却满心澎湃。生活从未变得容易，只不过是我们，变得更加坚强。别把最好的时光，浪费在无谓的等待与犹豫不决中。人生不如意之事有之八九，常想一二，不思八九，事事如意。每一个成功者都有一个开始，勇于开始，才能找到成功的路。没有合格的黑夜，也就无所谓真正的黎明。每个生命都有裂缝，那才会有光线进来。你别羡慕她的漂亮，总会有人爱上你的善良。如果你明白你去的方向，全世界都会为你让路。岁月很长人海茫茫，你别回头也别将就。外面不像你想的那么好,风雨都要自己挡,愿每个独自走夜路的你,都足够坚强。能让你精致的，除了化妆品，最厉害的是知识、努力和爱。不要太乖，不想做的事可以拒绝，做不到的事不用勉强，不喜欢的话假装没听见，你的人生不是用来讨好别人，而是善待自己。这世界已经很差劲了，是那些心里干净的人，让它保留了最后一丝温暖和尊严，也许我们都没什么大出息，还有点笨，这都没关系，但请记得一直努力做个善良的人。生活本就是一场恶战，给你的是止疼药也好，是一巴掌也罢，最终都是要单枪匹马，练就自身胆量。余生很贵， 别为难自己， 放下过往，放下曾经， 放过自己。没必要刻意遇见谁，也不急于拥有谁，更不勉强留住谁 。一切顺其自然，最好的自己留给最后的人。因为，约还没有赴，你还没有见着，事还没有成。所以，为之千千万万遍努力。原来，爱与不爱，都与结局无关，有种感情，凝眸，就是永远。没有人可以左右你的人生，只是很多时候我们需要多一些勇气，去坚定自己的选择。一叶绽放一追寻，一花盛开一世界，一生相思为一人。你就像我没赶上的公车，没尝到的小吃，没做完的美梦，没看全的电影，总归是憾事。慢慢觉得所有回不去的日子都有它的道理，而所有回不来的人，也自有他的原因。有时候，喝酒并不是因为喜欢酒的味道，只是喜欢醉的感觉。因为你在风里，所以每一个有风的日暮晨曦，都有我的欢喜。喜欢黄昏时分秾丽的晚霞，喜欢四季更迭的季风讯息，但还是最喜欢你。岁月很长人海茫茫，你别回头也别将就。那年，杏花微雨，你衣袂翻飞，飘逸若仙；那日，幽燕双飞，你抚琴轻叹，怅望青天；那刻，落花盘旋，你翩然起舞，醉笑离欢。昨夜庭院歌舞尽，今日落花飘满园，空余诗歌绕悬梁，奈何逝雪落无声。远望飞花落，难闻虫鸟鸣，落雪压寒梅，只嗅残花香。我也曾踏入过这滚滚红尘，江湖深深，年少懵懂却落得满身伤痕。如今断念成空已孑然一身，月落星沉，坐闲亭看尽人间假假真真。人的心可以忍耐的创伤程度是有限的，有些伤痛会记一生，虽然提起来难免隐隐作痛，但也会警示自己以后不可再犯同样的错，可是有些伤痛，还是就此忘掉比较好。朝花向晚，总是做梦人的一厢情愿，不能消世间风雨只能看一场美丽的花落人亡，艳骨留香风流委地。生死相望本太痛，身为看客也担不起这份破灭。尘缘从来都如水，罕须泪，何尽一生情？转身，一缕冷香远，逝雪深，笑意浅。来世你渡我，可愿？心微动奈何情己远，物也非，人也非，事事非，往日不可追。我拼了命不负这流年，只想和你看一场雪月风花，不错过你生如夏花之姿，你倾我国城，覆我年华，做我之王，如此，便足以。七百年以前你说：相遇不过是为了分离。七百年过后你又说：轮回也不过是为了等待。不知多少年过去，我终于舍得折去了岁末最后一枝桃花。花损芳谢，忆昨残红落街。风也清绝，霜也凌烈，独抱浓愁宿月，泪融残粉似雪。戏子入画，一生一天涯。红颜白发，青丝芳华。演尽他和她，谁懂心中话？缘聚缘散缘如水，背负万丈尘寰，只为一句，等待下一次相逢。头顶乌纱，手持上书象牙。殿上喧哗，私中藏花。满屋白银华，榨尽千万家。草庐为家，明月入篱笆。清泉煮茶，闲话桑麻。溪边摘芦花，柳下喜春芽。一壶清茶，盈盈几段闲话。夕阳暮下，嫩绿新芽。人间繁华赏罢，两袖清风归家。记忆想是倒在掌心的水，不论你摊开还是紧握，终究还是会从指缝中一滴一滴流淌干净。山谷悠悠，蝶舞翩翩，琴瑟和，仙音缭绕，轻歌曼曼，所谓此生不负。我听闻，你为了她，废一身风雅，饮水无茶，从此落魄离魂，半城烟沙。血染江山的画,怎敌你眉间一点朱砂,覆了天下也罢,始终不过一场繁华血染江山的画，怎敌你眉间一点朱砂，负了天下也罢，始终不过一场繁华岁月蹁跹人知否，花开雪融又一秋。青丝已换满白头，谁知此生几回眸？只愿世间风景千般万般熙攘过后，字里行间，人我两忘，相对无言。若我白发苍苍，容颜迟暮，你会不会，依旧如此，牵我双手，倾世温柔。醉后不知天在水，满船清梦压星河此生如若不是你，何愁青丝配白衣风月入我相思局，怎堪相思未相许二斤桃花酿做酒，万杯不及你温柔愿我如星君如月，夜夜流光相皎洁笙歌不见故人散，十里长欢难再寻远赴人间惊鸿宴，一睹人间盛世颜温山软水万千，不及你 眉眼半分我与春风携过客，你携秋水揽星河以梦为马，不负韶华何来人间一惊鸿，只是世间一俗人不用看日月，你就是星辰你踏万千星河而来，有乘舟奔赴远方世人皆唱桃之夭夭 , 见你才知灼灼其华山外青山楼外楼 , 江山不及你温柔终有弱水替沧海 , 在无相思寄巫山君不见高堂明镜悲白发 , 朝如青丝暮成雪长街长，烟花繁，你挑灯回看，短亭短，红尘辗，我把萧再叹雁门雪大 姑娘别跟了.我应山间等鹤鸣 却因思君到天明.你是惊鸿一-面一骑绝尘亦是- 一眼万年风尘仆仆烟雨归尘星月归你我归山川湖海也归你眉眼笑意.世间的温柔皆如干净的云朵和你.拨雪寻春，烧灯续昼。苍山负雪，明烛天南。天下人何限，慊慊独为汝。老来多健忘，唯不忘相思。玲珑少年在岸上，守护一生时光。茕茕白兔，东走西顾。衣不如新，人不如故。灼灼桃花，三千繁华，却似世间独独只有一个他。滴不尽相思血泪抛红豆，开不完春柳春花满画楼。韶华不为少年留，恨悠悠，几时休。少年不知愁，未料得，红鸾帐前的白衣水袖，拢了一世清愁。荣华谢后，江山永寂。剑起渺渺峰峦，遥见繁烟纷飞落，百花谢，大梦似长歌。花开满塘，水墨莲香。红笺小字，说尽平生意。鸿雁在云鱼在水，惆怅此情难寄！你挑灯回看，我把萧再叹我是人间惆怅客，断肠声里忆平生散落天涯，花落成伤，却也是物是人非半句话半首蝶恋花，半杯茶半杯湖底沙锦年你是我抓不住的光，素时你是我挥不走的影人在天涯月是天下客，君是人间绝色花看半开，酒饮微醺。你我皆风华正茂，梦死方坠人生暮年";
                    randomTextList = new ArrayList<>();
                    String[] split = randomText.split("。");
                    Collections.addAll(randomTextList, split);
                }
            }
        }
        Set<String> stringSet = RandomUtil.randomEleSet(randomTextList, RandomUtil.randomInt(1, 4));
        String randomText = String.join("", stringSet);
        return randomText.substring(0, Math.min(randomText.length(), textLength));
    }


    private static final String ID_CARD_ADDRESS = "350583";
    private static final String ID_CARD_LAST = "0123456789X";

    /**
     * 随机获取一个身份证
     */
    public static String idCard() {
        String birthday = LocalDate.ofEpochDay(RandomUtil.randomInt(0, 15000)).toString().replaceAll("-", "");
        String x = RandomUtil.randomString(ID_CARD_LAST, 1);
        return ID_CARD_ADDRESS + birthday + RandomUtil.randomNumbers(3) + x;
    }


    private static Region region;

    public static String address() {
        Region region = getRegion();
        List<Region> children = region.getChildren();
        Region region1 = children.get(RandomUtil.randomInt(0, children.size()));
        List<Region> children1 = region1.getChildren();
        Region region2 = children1.get(RandomUtil.randomInt(0, children1.size()));
        return region1.getText() + region2.getText() + RandomUtil.randomInt(100, 1000) + "号";
    }

    private static Region getRegion() {
        if (region == null) {
            synchronized (TestUtil.class) {
                if (region == null) {
                    String addressJson = "{\"children\":[{\"children\":[{\"children\":[],\"id\":\"1502\",\"text\":\"市辖区\"},{\"children\":[],\"id\":\"1503\",\"text\":\"鼓楼区\"},{\"children\":[],\"id\":\"1504\",\"text\":\"台江区\"},{\"children\":[],\"id\":\"1505\",\"text\":\"仓山区\"},{\"children\":[],\"id\":\"1506\",\"text\":\"马尾区\"},{\"children\":[],\"id\":\"1507\",\"text\":\"晋安区\"},{\"children\":[],\"id\":\"1508\",\"text\":\"闽侯县\"},{\"children\":[],\"id\":\"1509\",\"text\":\"连江县\"},{\"children\":[],\"id\":\"1510\",\"text\":\"罗源县\"},{\"children\":[],\"id\":\"1511\",\"text\":\"闽清县\"},{\"children\":[],\"id\":\"1512\",\"text\":\"永泰县\"},{\"children\":[],\"id\":\"1513\",\"text\":\"平潭县\"},{\"children\":[],\"id\":\"1514\",\"text\":\"福清市\"},{\"children\":[],\"id\":\"1515\",\"text\":\"长乐市\"}],\"id\":\"149\",\"text\":\"福州市\"},{\"children\":[{\"children\":[],\"id\":\"1516\",\"text\":\"市辖区\"},{\"children\":[],\"id\":\"1517\",\"text\":\"思明区\"},{\"children\":[],\"id\":\"1518\",\"text\":\"海沧区\"},{\"children\":[],\"id\":\"1519\",\"text\":\"湖里区\"},{\"children\":[],\"id\":\"1520\",\"text\":\"集美区\"},{\"children\":[],\"id\":\"1521\",\"text\":\"同安区\"},{\"children\":[],\"id\":\"1522\",\"text\":\"翔安区\"}],\"id\":\"150\",\"text\":\"厦门市\"},{\"children\":[{\"children\":[],\"id\":\"1523\",\"text\":\"市辖区\"},{\"children\":[],\"id\":\"1524\",\"text\":\"城厢区\"},{\"children\":[],\"id\":\"1525\",\"text\":\"涵江区\"},{\"children\":[],\"id\":\"1526\",\"text\":\"荔城区\"},{\"children\":[],\"id\":\"1527\",\"text\":\"秀屿区\"},{\"children\":[],\"id\":\"1528\",\"text\":\"仙游县\"}],\"id\":\"151\",\"text\":\"莆田市\"},{\"children\":[{\"children\":[],\"id\":\"1529\",\"text\":\"市辖区\"},{\"children\":[],\"id\":\"1530\",\"text\":\"梅列区\"},{\"children\":[],\"id\":\"1531\",\"text\":\"三元区\"},{\"children\":[],\"id\":\"1532\",\"text\":\"明溪县\"},{\"children\":[],\"id\":\"1533\",\"text\":\"清流县\"},{\"children\":[],\"id\":\"1534\",\"text\":\"宁化县\"},{\"children\":[],\"id\":\"1535\",\"text\":\"大田县\"},{\"children\":[],\"id\":\"1536\",\"text\":\"尤溪县\"},{\"children\":[],\"id\":\"1537\",\"text\":\"沙县\"},{\"children\":[],\"id\":\"1538\",\"text\":\"将乐县\"},{\"children\":[],\"id\":\"1539\",\"text\":\"泰宁县\"},{\"children\":[],\"id\":\"1540\",\"text\":\"建宁县\"},{\"children\":[],\"id\":\"1541\",\"text\":\"永安市\"}],\"id\":\"152\",\"text\":\"三明市\"},{\"children\":[{\"children\":[],\"id\":\"1542\",\"text\":\"市辖区\"},{\"children\":[],\"id\":\"1543\",\"text\":\"鲤城区\"},{\"children\":[],\"id\":\"1544\",\"text\":\"丰泽区\"},{\"children\":[],\"id\":\"1545\",\"text\":\"洛江区\"},{\"children\":[],\"id\":\"1546\",\"text\":\"泉港区\"},{\"children\":[],\"id\":\"1547\",\"text\":\"惠安县\"},{\"children\":[],\"id\":\"1548\",\"text\":\"安溪县\"},{\"children\":[],\"id\":\"1549\",\"text\":\"永春县\"},{\"children\":[],\"id\":\"1550\",\"text\":\"德化县\"},{\"children\":[],\"id\":\"1551\",\"text\":\"金门县\"},{\"children\":[],\"id\":\"1552\",\"text\":\"石狮市\"},{\"children\":[],\"id\":\"1553\",\"text\":\"晋江市\"},{\"children\":[],\"id\":\"1554\",\"text\":\"南安市\"}],\"id\":\"153\",\"text\":\"泉州市\"},{\"children\":[{\"children\":[],\"id\":\"1555\",\"text\":\"市辖区\"},{\"children\":[],\"id\":\"1556\",\"text\":\"芗城区\"},{\"children\":[],\"id\":\"1557\",\"text\":\"龙文区\"},{\"children\":[],\"id\":\"1558\",\"text\":\"云霄县\"},{\"children\":[],\"id\":\"1559\",\"text\":\"漳浦县\"},{\"children\":[],\"id\":\"1560\",\"text\":\"诏安县\"},{\"children\":[],\"id\":\"1561\",\"text\":\"长泰县\"},{\"children\":[],\"id\":\"1562\",\"text\":\"东山县\"},{\"children\":[],\"id\":\"1563\",\"text\":\"南靖县\"},{\"children\":[],\"id\":\"1564\",\"text\":\"平和县\"},{\"children\":[],\"id\":\"1565\",\"text\":\"华安县\"},{\"children\":[],\"id\":\"1566\",\"text\":\"龙海市\"}],\"id\":\"154\",\"text\":\"漳州市\"},{\"children\":[{\"children\":[],\"id\":\"1567\",\"text\":\"市辖区\"},{\"children\":[],\"id\":\"1568\",\"text\":\"延平区\"},{\"children\":[],\"id\":\"1569\",\"text\":\"建阳区\"},{\"children\":[],\"id\":\"1570\",\"text\":\"顺昌县\"},{\"children\":[],\"id\":\"1571\",\"text\":\"浦城县\"},{\"children\":[],\"id\":\"1572\",\"text\":\"光泽县\"},{\"children\":[],\"id\":\"1573\",\"text\":\"松溪县\"},{\"children\":[],\"id\":\"1574\",\"text\":\"政和县\"},{\"children\":[],\"id\":\"1575\",\"text\":\"邵武市\"},{\"children\":[],\"id\":\"1576\",\"text\":\"武夷山市\"},{\"children\":[],\"id\":\"1577\",\"text\":\"建瓯市\"}],\"id\":\"155\",\"text\":\"南平市\"},{\"children\":[{\"children\":[],\"id\":\"1578\",\"text\":\"市辖区\"},{\"children\":[],\"id\":\"1579\",\"text\":\"新罗区\"},{\"children\":[],\"id\":\"1580\",\"text\":\"永定区\"},{\"children\":[],\"id\":\"1581\",\"text\":\"长汀县\"},{\"children\":[],\"id\":\"1582\",\"text\":\"上杭县\"},{\"children\":[],\"id\":\"1583\",\"text\":\"武平县\"},{\"children\":[],\"id\":\"1584\",\"text\":\"连城县\"},{\"children\":[],\"id\":\"1585\",\"text\":\"漳平市\"}],\"id\":\"156\",\"text\":\"龙岩市\"},{\"children\":[{\"children\":[],\"id\":\"1586\",\"text\":\"市辖区\"},{\"children\":[],\"id\":\"1587\",\"text\":\"蕉城区\"},{\"children\":[],\"id\":\"1588\",\"text\":\"霞浦县\"},{\"children\":[],\"id\":\"1589\",\"text\":\"古田县\"},{\"children\":[],\"id\":\"1590\",\"text\":\"屏南县\"},{\"children\":[],\"id\":\"1591\",\"text\":\"寿宁县\"},{\"children\":[],\"id\":\"1592\",\"text\":\"周宁县\"},{\"children\":[],\"id\":\"1593\",\"text\":\"柘荣县\"},{\"children\":[],\"id\":\"1594\",\"text\":\"福安市\"},{\"children\":[],\"id\":\"1595\",\"text\":\"福鼎市\"}],\"id\":\"157\",\"text\":\"宁德市\"}],\"id\":\"13\",\"text\":\"福建省\"}";
                    region = JSONUtil.toBean(addressJson, Region.class);
                }
            }
        }
        return region;
    }


    private static final String[] prefixPhone = {"130", "131", "132", "133", "135", "137", "138", "170", "176", "187", "189"};

    /**
     * 随机获取一个手机号码
     */
    public static String phone() {
        return RandomUtil.randomEle(prefixPhone) + RandomUtil.randomNumbers(8);
    }

    private static final String[] prefixTel = {"0591", "0592", "0593", "0594", "0595", "0596", "0597", "0598", "0599"};

    /**
     * 随机获取一个电话号码
     */
    public static String tel() {
        return RandomUtil.randomEle(prefixTel) + "-8" + RandomUtil.randomNumbers(6);
    }

    /**
     * 随机获取一个人名
     */
    public static String userName() {
        return RandomUtil.randomEle(FAMILY_NAMES) + RandomUtil.randomEle(GIVEN_NAMES);
    }

    private static final String[] FAMILY_NAMES = {
            "赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈",
            "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许",
            "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏",
            "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章",
            "云", "苏", "潘", "葛", "奚", "范", "彭", "郎", "鲁", "韦",
            "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳",
            "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺",
            "倪", "汤", "滕", "殷", "罗", "毕", "郝", "邬", "安", "常",
            "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余",
            "元", "卜", "顾", "孟", "平", "黄", "和", "穆", "萧", "尹"};

    private static final String[] GIVEN_NAMES = {
            "子璇", "淼", "国栋", "夫子", "瑞堂", "甜", "敏", "尚", "国贤", "贺祥", "晨涛",
            "昊轩", "易轩", "益辰", "益帆", "益冉", "瑾春", "瑾昆", "春齐", "杨", "文昊",
            "东东", "雄霖", "浩晨", "熙涵", "溶溶", "冰枫", "欣欣", "宜豪", "欣慧", "建政",
            "美欣", "淑慧", "文轩", "文杰", "欣源", "忠林", "榕润", "欣汝", "慧嘉", "新建",
            "建林", "亦菲", "林", "冰洁", "佳欣", "涵涵", "禹辰", "淳美", "泽惠", "伟洋",
            "涵越", "润丽", "翔", "淑华", "晶莹", "凌晶", "苒溪", "雨涵", "嘉怡", "佳毅",
            "子辰", "佳琪", "紫轩", "瑞辰", "昕蕊", "萌", "明远", "欣宜", "泽远", "欣怡",
            "佳怡", "佳惠", "晨茜", "晨璐", "运昊", "汝鑫", "淑君", "晶滢", "润莎", "榕汕",
            "佳钰", "佳玉", "晓庆", "一鸣", "语晨", "添池", "添昊", "雨泽", "雅晗", "雅涵",
            "清妍", "诗悦", "嘉乐", "晨涵", "天赫", "玥傲", "佳昊", "天昊", "萌萌", "若萌"};

    /**
     * 随机获取一个lng
     * @return lng
     */
    public static BigDecimal getLng() {
        return new BigDecimal("118.08"+RandomUtil.randomNumbers(6));
    }

    /**
     * 随机获取一个lat
     * @return lat
     */
    public static BigDecimal getLat() {
        return new BigDecimal("24.48"+RandomUtil.randomNumbers(6));
    }

    /**
     * 获取一个过去的时间戳
     */
    public static long beforeTime() {
        return beforeTimeToDate().getTime();
    }

    /**
     * 获取一个过去的时间
     */
    public static Date beforeTimeToDate() {
        return DateUtil.offsetMinute(DateUtil.yesterday(), -RandomUtil.randomInt(0, 99999));
    }

    /**
     * 获取一个过去的时间
     */
    public static LocalDateTime beforeTimeToLocalDateTime() {
        return LocalDateTimeUtil.of(beforeTimeToDate());
    }

    /**
     * 获取一个指定日期之前的时间
     */
    public static long beforeTime(Date date) {
        return beforeTimeToDate(date).getTime();
    }

    /**
     * 获取一个指定日期之前的时间
     */
    public static Date beforeTimeToDate(Date date) {
        return DateUtil.offsetMinute(date, -RandomUtil.randomInt(0, 99999));
    }

    /**
     * 获取一个指定日期之前的时间
     */
    public static long beforeTime(long timestamp) {
        return beforeTimeToDate(timestamp).getTime();
    }

    /**
     * 获取一个指定日期之前的时间
     */
    public static Date beforeTimeToDate(long timestamp) {
        return DateUtil.offsetMinute(DateUtil.date(timestamp), -RandomUtil.randomInt(0, 99999));
    }

    /**
     * 获取一个指定日期之前的时间
     */
    public static LocalDateTime beforeTimeToLocalDateTime(LocalDateTime localDateTime) {
        return LocalDateTimeUtil.of(beforeTimeToDate(DateUtil.date(localDateTime)));
    }

    /**
     * 获取一个未来的时间戳
     */
    public static long afterTime() {
        return afterTimeToDate().getTime();
    }

    /**
     * 获取一个未来的时间
     */
    public static Date afterTimeToDate() {
        return DateUtil.offsetMinute(DateUtil.tomorrow(), RandomUtil.randomInt(0, 99999));
    }

    /**
     * 获取一个未来的时间
     */
    public static LocalDateTime afterTimeToLocalDateTime() {
        return LocalDateTimeUtil.of(afterTimeToDate());
    }

    /**
     * 获取一个指定日期之后的时间
     */
    public static long afterTime(Date date) {
        return afterTimeToDate(date).getTime();
    }

    /**
     * 获取一个指定日期之后的时间
     */
    public static Date afterTimeToDate(Date date) {
        return DateUtil.offsetMinute(date, RandomUtil.randomInt(0, 99999));
    }

    /**
     * 获取一个指定日期之前的时间
     */
    public static long afterTime(long timestamp) {
        return afterTimeToDate(timestamp).getTime();
    }

    /**
     * 获取一个指定日期之前的时间
     */
    public static Date afterTimeToDate(long timestamp) {
        return DateUtil.offsetMinute(DateUtil.date(timestamp), RandomUtil.randomInt(0, 99999));
    }

    /**
     * 获取一个指定日期之前的时间
     */
    public static LocalDateTime afterTimeToLocalDateTime(LocalDateTime localDateTime) {
        return LocalDateTimeUtil.of(afterTimeToDate(DateUtil.date(localDateTime)));
    }

    /**
     * 获取最近的时间戳
     */
    public static long latelyTime() {
        return latelyTimeToDate().getTime();
    }

    /**
     * 获取最近的时间
     */
    public static Date latelyTimeToDate() {
        return DateUtil.offsetMinute(DateUtil.date(), RandomUtil.randomInt(-99999, 99999));
    }

    /**
     * 获取一个未来的时间
     */
    public static LocalDateTime latelyTimeToLocalDateTime() {
        return LocalDateTimeUtil.of(latelyTimeToDate());
    }

    /**
     * 随机获取列表中的一个元素
     */
    public void randomEleTest() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i + "");
        }
        for (int i = 0; i < 100; i++) {
            String ele = RandomUtil.randomEle(list);
            System.out.println(ele);
        }
    }

    /**
     * 随机获得列表中的一定量的不重复元素，返回Set
     */
    public void randomEleSetTest() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i + "");
        }
        Set<String> stringSet = RandomUtil.randomEleSet(list, 5);
        for (String s : stringSet) {
            System.out.println(s);
        }
    }

    /**
     * 获得一个随机的字符串（只包含数字和字符）
     */
    public void randomStringTest() {
        for (int i = 0; i < 100; i++) {
            System.out.println(RandomUtil.randomString("我是java大神", 9));
        }
    }

    /**
     * 获得一个只包含数字的字符串
     */
    public void randomNumbersTest() {
        for (int i = 0; i < 100; i++) {
            System.out.println(RandomUtil.randomNumbers(5));
        }
    }

    /**
     * 权重随机生成器，传入带权重的对象，然后根据权重随机获取对象
     */
    public void WeightRandomTest() {
        WeightRandom<String> random = new WeightRandom<>();
        random.add("1", 1);
        random.add("3", 3);
        int san = 0, yi = 0;
        for (int i = 0; i < 100000; i++) {

            String next = random.next();
            switch (next) {
                case "3":
                    san++;
                    break;
                case "1":
                    yi++;
                    break;
                default:
                    break;
            }
        }
        System.out.println((double) 1 / 3);
        System.out.println((double) yi / san);
    }

    static class Region {
        private String id;
        private String text;
        private List<Region> children = new ArrayList<>();

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public List<Region> getChildren() {
            return children;
        }

        public void setChildren(List<Region> children) {
            this.children = children;
        }

        @Override
        public String toString() {
            return "{" +
                    "\"id\":" + '\"' + id + '\"' +
                    ",\"text\":" + '\"' + text + '\"' +
                    ",\"children\":" + children +
                    '}';
        }
    }

}
