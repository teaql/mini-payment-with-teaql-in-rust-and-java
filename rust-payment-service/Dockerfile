FROM alpine:latest
RUN apk add --no-cache ca-certificates tzdata
WORKDIR /app
COPY payment-service-rust /app/payment-service-rust
EXPOSE 8080
ENTRYPOINT ["/app/payment-service-rust"]
