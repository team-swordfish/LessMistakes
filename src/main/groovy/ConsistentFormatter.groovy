
class ConsistentFormatter {
    String format(List<Integer> integers) {
        integers.collect{
            it -> " " * (new Random().nextInt(it)) + it
        }.join(",")
    }
}
