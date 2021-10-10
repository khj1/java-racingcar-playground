package study.racingcar;

import java.util.List;

public class ResultView {
    public static void printInit() {
        System.out.println("실행 결과");
    }

    public static void printResults(Cars cars) {
        cars.getCars().forEach(ResultView::printResult);
        System.out.println();
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

    public static void printWinners(Winners winners) {
        System.out.println(toStringWinners(winners.getWinners()) + "가 최종 우승했습니다.");
    }

    private static String toStringWinners(List<Car> winners) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < winners.size()-1; i++) {
            sb.append(winners.get(i).getName()).append(", ");
        }
        sb.append(winners.get(winners.size() - 1).getName());

        return sb.toString();
    }
}
