Kafka의 토픽을 수신하여 DB에 데이터를 저장하는 서버입니다.

</br>

Kafka의 파티션 개수(=수신 서버 대수)에 따른 속도 차이 (1만개 데이터 테스트)

</br>

1개 : 24초
</br>
2개 : 15초
</br>
3개 : 14초

</br>

결론
</br>
DB INSERT에 병목이 있어서 수행속도가 서버 대수에 맞춰서 줄어들지 않는것 같다.
</br>
적당한 파티션 개수를 설정해야할것 같다.
