package N_2022.March;

public class pro_line_1 {
    public static void main(String[] args) {
        int count = solution(new String[]{"team_name : db application_name : dbtest error_level : info message : test", "team_name : test application_name : I DONT CARE error_level : error message : x", "team_name : ThisIsJustForTest application_name : TestAndTestAndTestAndTest error_level : test message : IAlwaysTestingAndIWillTestForever", "team_name : oberervability application_name : LogViewer error_level : error"});
        System.out.println(count);
    }

    private static int solution(String[] logs) {
        int tLeng = "team_name : ".length();
        int aLeng = "application_name : ".length();
        int eLeng = "error_level : ".length();
        int mLeng = "message : ".length();
        int count = 0;
        for (String log : logs) {
            int aStart = log.indexOf("application_name");
            int eStart = log.indexOf("error_level");
            int mStart = log.indexOf("message");
            if (log.length() > 100) {
                count += 1;
            }
            else if (log.substring(0,tLeng).equals("team_name : ")) {
                if (check(log.substring(tLeng, aStart-1))) {
                    if (log.substring(aStart, aLeng + aStart).equals("application_name : ")) {
                        if (check(log.substring(aLeng + aStart, eStart-1))) {
                            if (log.substring(eStart, eLeng + eStart).equals("error_level : ")) {
                                if (check(log.substring(eLeng + eStart, mStart-1))) {
                                    if (log.substring(mStart, mLeng + mStart).equals("message : ")) {
                                        if (check(log.substring(mLeng + mStart, log.length()-1))) {
                                        } else {
                                            count+=1;
                                        }
                                    }
                                } else {
                                    count += 1;
                                }
                            } else {
                                count += 1;
                            }
                        } else {
                            count += 1;
                        }
                    } else {
                        count += 1;
                    }
                } else {
                    count += 1;

                }

            } else {
                count += 1;
            }
        }
        return count;
    }

    private static boolean check(String log) {
        char[] c = log.toCharArray();
        for (char char1 : c) {
            if (!((char1 >= 'a' && char1 <= 'z') || (char1 >= 'A' && char1 <= 'Z'))) {
                return false;
            }
        }
        return true;
    }

}
