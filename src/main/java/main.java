import java.util.*;

public class main {
    public static void main(String[] args) {
        q20();
    }

    // No.14 - 求數列和
    private static void q14() {
        double first = 2;       // 定義 分子
        double secend = 1;      // 定義 分母
        double total = 0;       // 定義 總和=0
        double temp;            // 定義 臨時用的值

        // 輸入 N 值
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入「N」:");
        int n = Integer.parseInt(scanner.nextLine());

        // 開始計算
        for (int i = 0; i < n; i++) {
            total += first / secend;        // 計算  分子/分母，並加到 總和 裡面
            temp = secend;                  // 紀錄分母的值
            secend = first;                 // 分母改為分子
            first += temp;                  // 分子加上原本分母的值
        }

        System.out.print("結果: " + total);    // 顯示最終結果
    }

    // No.15 - 找零錢
    private static void q15() {
        // 輸入 消費金額
        Scanner spendScanner = new Scanner(System.in);
        System.out.println("請輸入消費金額:");
        int spend = Integer.parseInt(spendScanner.nextLine());

        List<Integer> coinList = new ArrayList<Integer>();      // 建立零錢種類的列表
        // 輸入 幣值1
        System.out.println("請輸入第一個幣值:");
        coinList.add(Integer.parseInt(new Scanner(System.in).nextLine()));
        // 輸入 幣值2
        System.out.println("請輸入第二個幣值");
        coinList.add(Integer.parseInt(new Scanner(System.in).nextLine()));
        // 輸入 幣值3
        System.out.println("請輸入第三個幣值");
        coinList.add(Integer.parseInt(new Scanner(System.in).nextLine()));
        // 輸入 支付金額
        Scanner paidScanner = new Scanner(System.in);
        System.out.println("請輸入支付金額");
        int paid = Integer.parseInt(paidScanner.nextLine());

        Collections.sort(coinList);             // 將零錢種類 由小到大排列
        Collections.reverse(coinList);          // 反轉排列
        paid -= spend;                          // 總共找多少錢
        // 開始找零
        int number;
        for (int coin : coinList) {
            number = (int) Math.floor(paid / coin);
            if (number > 0) {
                paid -= number * coin;
                System.out.println(coin + " 元找 " + number + " 個");
            }
        }
        // 最後剩下多少 1 元
        if (paid > 0) {
            System.out.println("1 元找 " + paid + " 個");
        }
    }


    // No.16 - 求最大公因數(GCD) & 最小公倍數(LCM)
    private static void q16() {
        // 輸入 第一個數字
        Scanner firstScanner = new Scanner(System.in);
        System.out.println("請輸入一整數:");
        int first = Integer.parseInt(firstScanner.nextLine());
        // 輸入 第二個數字
        Scanner secondScanner = new Scanner(System.in);
        System.out.println("請輸入一整數:");
        int second = Integer.parseInt(secondScanner.nextLine());

        int LCM = first * second;
        /*
        輾轉相除 -> 取得最大公因數
        不要問我怎麼知道的，我用查的。
        方法 google: java 輾轉相除法 or java 求最大公因數 or java toss and divide
        https://www.itread01.com/content/1548500604.html
         */
        int r = first % second;
        while (r != 0) {
            first = second;
            second = r;
            r = first % second;
        }
        //顯示結果
        System.out.println("GCD 為 " + second + "、、LCM 為 " + LCM / second);
    }

    // No.17 - 檢查是否為迴文數(Palindrome)，如 12321。
    /*
        方法 google: java palindrome
        https://www.javatpoint.com/palindrome-program-in-java
     */
    private static void q17() {
        // 輸入 不超過 5 位數的整數
        String original;  // Objects of String class
        StringBuilder reverse = new StringBuilder();
        Scanner in = new Scanner(System.in);
        System.out.println("請輸入一整數:");
        original = in.nextLine();

        int length = original.length();      // 字串(String)的長度
        //////////////// 將字串從後面倒過來排列 /////////////
        // Reverse = 倒序
        for (int i = length - 1; i >= 0; i--) {
            reverse.append(original.charAt(i));
        }
        /////////////////////////////////////////////////

        // 比對倒序後的文字和原本的香不相同
        if (original.equals(reverse.toString())) {
            System.out.println("是迴文數");
        } else {
            System.out.println("不是迴文數");
        }
    }

    // No.18 - 將十進位轉換成 16進位
    /*
        方法 google: java hexadecimal
        https://www.w3resource.com/java-exercises/basic/java-basic-exercise-20.php

        這題比較難，建議直接被 C++ 的用法
     */
    private static void q18() {
        int dec_num;
        int rem;
        StringBuilder hexdec_num = new StringBuilder();  // 很難解釋...

        /* hexadecimal number digits [hex矩陣] */
        char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        // 輸入 第一個數字
        Scanner in = new Scanner(System.in);
        System.out.print("請輸入10進制數字:");
        dec_num = in.nextInt();

        while (dec_num > 0) {                           // 持續轉換直到沒有 數字為止
            rem = dec_num % 16;                         // 得到餘數 rem
            hexdec_num.insert(0, hex[rem]);       // 在第一個數字放入 餘數所對應的 hex矩陣
            dec_num = dec_num / 16;                     // 更新
        }
        System.out.println("換算結果：" + hexdec_num);
    }

    // No.19 - 轉換數字為國字 123 -> 一二三
    private static void q19() {
        // 建立中文比對的列表 -> 取出對應中文， chinese[0]= "一", chinese[7]= "八"
        String[] chinese = {"一", "二", "三", "四", "五", "六", "七", "八", "九"};

        // 輸入 第一個數字
        Scanner in = new Scanner(System.in);
        System.out.print("請輸入一整數: ");
        String inString = in.nextLine();                        // 取得輸入的字串
        char[] charArray = inString.toCharArray();              // 將字串改為陣列 (切割的概念)

        for (char c : charArray) {                              // 把每個字跑一次
            System.out.print(chinese[Integer.parseInt(String.valueOf(c)) - 1]); // 依序顯示對印的中文
        }
    }

    // No.20 - 不斷輸入，直到飛英文字母，然後統計 A E I O U 的次數
    private static void q20() {
        // 訂一個個字母的起始值為 0
        int a = 0;
        int e = 0;
        int i = 0;
        int o = 0;
        int u = 0;
        Scanner in = new Scanner(System.in);

        String inString;
        while (true) {
            System.out.print("請輸入字母：");
            inString = in.nextLine();
            // 如果字母為非英文則跳出迴圈 -> 正規表達式(regex)
            if (!inString.matches("[A-Za-z]")) {
                break;      // 跳出迴圈
            }
            inString = inString.toLowerCase();  // 將字母改為小寫
            // 檢查字母並記數
            switch (inString) {
                case "a":
                    a++;
                    break;
                case "e":
                    e++;
                    break;
                case "i":
                    i++;
                    break;
                case "o":
                    o++;
                    break;
                case "u":
                    u++;
                    break;
                default:        // 當沒有上序的字母，則不做動作
                    break;
            }
        }
        // 顯示結果
        System.out.print("A 出現 " + a + " 次、" + "E 出現 " + e + " 次、" + "I 出現 " + i + " 次、" + "O 出現 " + o + " 次、" + "U 出現 " + u + " 次、");
    }
}
