package com.referrals.app.dependency;

import java.util.HashSet;
import java.util.Set;

public class ReferralsDao {

	public static void main(String[] args) {

		Referral referral1 = new Referral(1, "Raja", "raja@gmail.com", "8939980528", 3, "Programmer");

		Set<Referral> referrals = new HashSet<Referral>();
		referrals.add(referral1);

		Associate associate = new Associate(1, "Nagaraj", "Associate", "6383414909", "Nagaraj@gmail.com", "CHN-TBM");
		
		AssociateDAO associateDAO = new AssociateDAO();
		associateDAO.createAssociate(associate);
		
		// SkillDao skillDao = new SkillDao();
		// skillDao.createSkill(new Skill(1, "Java"));
	}

}
