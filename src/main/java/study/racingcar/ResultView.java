package study.racingcar;

public class ResultView {
    public static void printInit() {
        System.out.println("실행 결과");
    }

    public static void printResults(Cars cars) {
        cars.getCars().forEach(ResultView::printResult);
    }

    private static void printResult(Car car) {
        String position = convertPositionToDash(car.getPosition());
        System.out.println(car.getName() + " : " + position);
    }

    private static String convertPositionToDash(Integer position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public void printWinners(Winners winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
