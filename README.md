# minio-achieve

[![License](https://img.shields.io/badge/License-MIT-green.svg?style=flat&logo=github)](https://www.mit-license.org)
[![OracleJDK](https://img.shields.io/badge/OracleJDK-17.0.4-success.svg?style=flat&logo=data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSI2NCIgaGVpZ2h0PSI2NCIgdmlld0JveD0iMCAwIDMyIDMyIj48cGF0aCBkPSJNMTEuNjIyIDI0Ljc0cy0xLjIzLjc0OC44NTUuOTYyYzIuNTEuMzIgMy44NDcuMjY3IDYuNjI1LS4yNjdhMTAuMDIgMTAuMDIgMCAwIDAgMS43NjMuODU1Yy02LjI1IDIuNjcyLTE0LjE2LS4xNi05LjI0NC0xLjU1em0tLjgtMy40NzNzLTEuMzM2IDEuMDE1Ljc0OCAxLjIzYzIuNzI1LjI2NyA0Ljg2Mi4zMiA4LjU1LS40MjdhMy4yNiAzLjI2IDAgMCAwIDEuMjgyLjgwMWMtNy41MzQgMi4yNDQtMTUuOTc2LjIxNC0xMC41OC0xLjYwM3ptMTQuNzQ3IDYuMDlzLjkwOC43NDgtMS4wMTUgMS4zMzZjLTMuNTggMS4wNy0xNS4wMTQgMS4zOS0xOC4yMiAwLTEuMTIyLS40OCAxLjAxNS0xLjE3NSAxLjctMS4yODIuNjk1LS4xNiAxLjA3LS4xNiAxLjA3LS4xNi0xLjIzLS44NTUtOC4xNzUgMS43NjMtMy41MjYgMi41MSAxMi43NyAyLjA4NCAyMy4yOTYtLjkwOCAxOS45ODMtMi40MDR6TTEyLjIgMTcuNjMzcy01LjgyNCAxLjM5LTIuMDg0IDEuODdjMS42MDMuMjE0IDQuNzU1LjE2IDcuNjk0LS4wNTMgMi40MDQtLjIxNCA0LjgxLS42NCA0LjgxLS42NHMtLjg1NS4zNzQtMS40NDMuNzQ4Yy01LjkzIDEuNTUtMTcuMzEyLjg1NS0xNC4wNTItLjc0OCAyLjc3OC0xLjMzNiA1LjA3Ni0xLjE3NSA1LjA3Ni0xLjE3NXptMTAuNDIgNS44MjRjNS45ODQtMy4xIDMuMjA2LTYuMDkgMS4yODItNS43MTctLjQ4LjEwNy0uNjk1LjIxNC0uNjk1LjIxNHMuMTYtLjMyLjUzNC0uNDI3YzMuNzk0LTEuMzM2IDYuNzg2IDQuMDA3LTEuMjMgNi4wOSAwIDAgLjA1My0uMDUzLjEwNy0uMTZ6bS05LjgzIDguNDQyYzUuNzcuMzc0IDE0LjU4Ny0uMjE0IDE0LjgtMi45NCAwIDAtLjQyNyAxLjA3LTQuNzU1IDEuODctNC45MTYuOTA4LTExLjAwNy44LTE0LjU4Ny4yMTQgMCAwIC43NDguNjQgNC41NDIuODU1eiIgZmlsbD0iIzRlNzg5NiIvPjxwYXRoIGQ9Ik0xOC45OTYuMDAxczMuMzEzIDMuMzY2LTMuMTUyIDguNDQyYy01LjE4MyA0LjExNC0xLjE3NSA2LjQ2NSAwIDkuMTM3LTMuMDQ2LTIuNzI1LTUuMjM2LTUuMTMtMy43NC03LjM3M0MxNC4yOTQgNi44OTMgMjAuMzMyIDUuMyAxOC45OTYuMDAxem0tMS43IDE1LjMzNWMxLjU1IDEuNzYzLS40MjcgMy4zNjYtLjQyNyAzLjM2NnMzLjk1NC0yLjAzIDIuMTM3LTQuNTQyYy0xLjY1Ni0yLjQwNC0yLjk0LTMuNTggNC4wMDctNy41ODcgMCAwLTEwLjk1MyAyLjcyNS01LjcxNyA4Ljc2M3oiIGZpbGw9IiNmNTgyMTkiLz48L3N2Zz4=)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![JUnit](https://img.shields.io/badge/JUnit-5.8.2-success.svg?style=flat&logo=junit5)](https://junit.org/junit5/docs/current/user-guide)
[![Gradle](https://img.shields.io/badge/Gradle-7.4.2-success.svg?style=flat&logo=gradle)](https://docs.gradle.org/7.2/userguide/installation.html)
[![Release](https://img.shields.io/badge/Release-0.2.0-informational.svg)](https://github.com/aaric/minio-achieve/releases)

> [MinIO Java Client Learning.](https://docs.min.io/docs/java-client-quickstart-guide.html)

## 1 [Deploy](https://docs.min.io/docs/minio-quickstart-guide.html)

|No.|Key|Value|Remark|
|:-:|---|---|---|
|1|MinIO Console|`http://127.0.0.1:9001`||
|2|Admin Account|`admin`||
|3|Admin Password|`admin123`||
|4|Normal Account|`newuser`|*Only authorize `newbucket` bucket admin permission*|
|5|Normal Password|`newuser123`||

```bash
# install
wget https://dl.min.io/server/minio/release/linux-amd64/minio && chmod +x ./minio

# single
export MINIO_ROOT_USER=admin
export MINIO_ROOT_PASSWORD=admin123
mkdir ./data{1..2}
./minio server ./data{1..2} --address "0.0.0.0:9000" --console-address "0.0.0.0:9001"
```

## 2 [Client](https://docs.min.io/docs/minio-client-complete-guide.html)

### 2.1 Install

```bash
# install
wget https://dl.min.io/client/mc/release/linux-amd64/mc && chmod +x ./mc
```

### 2.2 Command

#### 2.2.1 config

```bash
./mc config host rm local
./mc config host rm gcs
./mc config host rm s3
./mc config host add minio http://127.0.0.1:9000 admin admin123
./mc config host ls
```

#### 2.2.2 bucket

```bash
./mc ls minio
./mc mb minio/newbucket
date > test.txt
./mc cp test.txt minio/newbucket
./mc ls minio/newbucket
./mc cat minio/newbucket/test.txt
./mc cp minio/newbucket/test.txt .
./mc rm minio/newbucket/test.txt
./mc rb --force minio/newbucket

./mc du minio
./mc admin info minio/
```

#### 2.2.1 user

```bash
./mc admin user list minio
./mc admin user add minio newuser newuser123
#./mc admin user disable minio newuser
#./mc admin user enable minio newuser
./mc admin user info minio newuser
./mc admin user remove minio newuser
```

#### 2.2.1 admin

```bash
# https://docs.min.io/docs/minio-admin-complete-guide.html
./mc admin policy list minio
./mc admin policy info minio readonly
./mc admin policy info minio writeonly
./mc admin policy info minio readwrite
cat > newbucketAdmin.json <<-'EOF'
{
  "Version": "2012-10-17",
  "Statement": [{
    "Effect": "Allow",
    "Action": [
      "s3:*"
    ],
    "Resource": [
      "arn:aws:s3:::newbucket/*"
    ]
  }]
}
EOF
./mc admin policy add minio newbucketAdmin newbucketAdmin.json
./mc admin policy remove minio newbucketAdmin

./mc admin policy set minio newbucketAdmin user=newuser
./mc admin policy unset minio newbucketAdmin user=newuser
```
