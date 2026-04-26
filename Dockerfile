FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY build/distributions/MapTapSlackApp.tar /app/
RUN tar -xvf MapTapSlackApp.tar
ENV PATH="/app/MapTapSlackApp/bin:${PATH}"
CMD ["MapTapSlackApp"]