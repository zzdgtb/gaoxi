package com.gaoxi.tmp;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/29
 * @version: 1.0.0
 */
public enum DeployEnv {
    DEPLOY_ENV_EDAS_HSF("edas_hsf"),
    DEPLOY_ENV_EDAS_SPRINGCLOUD("edas_springcloud"),
    DEPLOY_ENV_SPRINGCLOUD("springcloud");

    public static final String DEPLOY = "dtyunxi.deploy";
    private String env;

    private DeployEnv(String env) {
        this.env = env;
    }

    public String getEnv() {
        return this.env;
    }

    public static DeployEnv getDeployEnv() {
        return getDeployEnvEnum(System.getProperty("dtyunxi.deploy"));
    }

    public static boolean isEdas() {
        DeployEnv deployEnv = getDeployEnv();
        return DEPLOY_ENV_EDAS_HSF == deployEnv || DEPLOY_ENV_EDAS_SPRINGCLOUD == deployEnv;
    }

    public static boolean isEdasHsf() {
        return DEPLOY_ENV_EDAS_HSF == getDeployEnv();
    }

    public static boolean isSpringCloud() {
        DeployEnv deployEnv = getDeployEnv();
        return DEPLOY_ENV_EDAS_SPRINGCLOUD == deployEnv || DEPLOY_ENV_SPRINGCLOUD == deployEnv;
    }

    public static boolean isSpringCloudPure() {
        return DEPLOY_ENV_EDAS_SPRINGCLOUD == getDeployEnv();
    }

    private static DeployEnv getDeployEnvEnum(String strDeploy) {
        if (DEPLOY_ENV_EDAS_HSF.getEnv().equals(strDeploy)) {
            return DEPLOY_ENV_EDAS_HSF;
        } else if (DEPLOY_ENV_EDAS_SPRINGCLOUD.getEnv().equals(strDeploy)) {
            return DEPLOY_ENV_EDAS_SPRINGCLOUD;
        } else {
            return DEPLOY_ENV_SPRINGCLOUD.getEnv().equals(strDeploy) ? DEPLOY_ENV_SPRINGCLOUD : DEPLOY_ENV_EDAS_SPRINGCLOUD;
        }
    }
}
