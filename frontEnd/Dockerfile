FROM --platform=$BUILDPLATFORM node:19-bullseye-slim AS builder

RUN mkdir /project
WORKDIR /project

RUN npm install -g @angular/cli@19.1.7

COPY package.json package-lock.json ./
RUN npm ci

COPY . .
CMD ["ng","serve","--host","0.0.0.0"]


FROM builder AS dev-envs

RUN <<EOF
apt-get update
apt-get install -y -no-install-recommends git
EOF

RUN <<EOF
useradd -s /bin/bash -m vscode
groupadd docker
usermod -aG docker vscode
EOF
# install Docker tools (cli, buildx, compose)
COPY --from=gloursdocker/docker / /

CMD ["ng", "serve", "--host", "0.0.0.0"]