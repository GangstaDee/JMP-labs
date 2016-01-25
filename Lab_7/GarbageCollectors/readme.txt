Serial Collector:
-XX:+UseSerialGC -Xloggc:C:\#######\GarbageCollectors\serial-gc.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps -Xms6m -Xmx18m -Xmn2m -XX:MetaspaceSize=20m -XX:MaxMetaspaceSize=30m

Parallel Collector:
-XX:+UseParallelGC -Xloggc:C:\#######\GarbageCollectors\parallel-gc.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps -Xms3m -Xmx12m -Xmn1m -XX:MetaspaceSize=20m -XX:MaxMetaspaceSize=20m

Parallel Old Collector:
-XX:+UseParallelOldGC -Xloggc:C:\#######\GarbageCollectors\parallel-old-gc.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps -Xms9m -Xmx18m -Xmn3m -XX:MetaspaceSize=40m -XX:MaxMetaspaceSize=40m

Concurrent Mark Sweep (CMS) Collector  with 2 Parallel CMS Threads:
-XX:+UseConcMarkSweepGC -XX:ParallelCMSThreads=2 -Xloggc:C:\#######\GarbageCollectors\cms-gc.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps -Xms6m -Xmx18m -Xmn2m -XX:MetaspaceSize=20m -XX:MaxMetaspaceSize=30m

G1 Garbage Collector:
-XX:+UseG1GC -Xloggc:C:\#######\GarbageCollectors\g1-gc.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps -Xms4m -Xmx16m -Xmn2m -XX:MetaspaceSize=12m -XX:MaxMetaspaceSize=18m