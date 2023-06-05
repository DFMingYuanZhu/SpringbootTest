retry(3) {
    for (int i = 0; i < 10; i++) {
        branches["branch${i}"] = {
            node {
                retry(3) {
                    checkout scm
                }
                sh 'make world'
            }
        }
    }
}
parallel branches
