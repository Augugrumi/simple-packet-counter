Simple counter
==============

This is a simple java packet counter.

## Build

Build it with
```sh
docker build -t augugrumi/packetcounter .
```

## Run

Run with:
```sh
docker run --rm -p6789:80 augugrumi/packetcounter
```

Then open your browser and browse to `localhost:6789`.
Optionally, do it with curl:
```sh
curl localhost:6789
```
