FROM alpine:latest
RUN apk add --no-cache ca-certificates tzdata
WORKDIR /app
COPY axum-payment-service /app/axum-payment-service
EXPOSE 8080
ENTRYPOINT ["/app/axum-payment-service"]
