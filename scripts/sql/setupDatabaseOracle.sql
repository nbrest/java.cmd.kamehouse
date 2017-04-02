-- ********************************
-- *** Last updated: 2017/04/02 ***
-- ********************************

-- Create user:
CREATE USER baseappUser IDENTIFIED BY baseappPwd;

-- Grant permissions:
GRANT connect, resource TO baseappUser;
