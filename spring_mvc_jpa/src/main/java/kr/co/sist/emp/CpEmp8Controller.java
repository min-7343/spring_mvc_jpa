package kr.co.sist.emp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;	;;

@Controller
public class CpEmp8Controller {
	
	@Autowired(required = false)
	private CpEmp8Service ces;
	
	@RequestMapping(value="/",method={GET,POST})
	public String index(Model model) {
		model.addAttribute("empList", ces.searchAllCpEmp8());
		return "index";
		
	}
	@GetMapping(value="/emp/empAddFrm")
	public String empAddFrm( ) {
		return "emp/empAddFrm";
	}
	
	
	
	@PostMapping({"/emp/empAddProcess","/emp/empModifyProcess"})
	public String empAddFrmProcess(HttpServletRequest request, CpEmp8Entity cee, Model model ) {
		System.out.println(request.getRequestURI());
		String jobMsg="추가";
		if("/emp/empModifyProcess".equals(request.getRequestURI())){
			jobMsg="변경";
		}//end if
		
		CpEmp8Entity ceResult=null;
		try {
			ceResult=ces.addModifyCpEmp8(cee);
		}catch(IllegalArgumentException iae) {
			iae.printStackTrace();
		}//end catch
	
		System.out.println(ceResult);
		
		model.addAttribute("jobMsg",jobMsg );
		model.addAttribute("ceResult",ceResult );
		//null 또는 값을 가진 객체
		
		return "emp/empAddResult";
	}//empAddFrmProcess
	
	
	@GetMapping("/emp/searchOneEmp")
	public String searchOneEmp(int empno, Model model) {
		
		CpEmp8Entity ceeResult=ces.searchOneEmp(empno);
		model.addAttribute("empData",ceeResult);
		
		return "emp/empDetail";
	}//searchOneEmp
	@PostMapping("/emp/removeEmp")
	public String removeEmp(int empno, Model model) {
		
		model.addAttribute("removeMsg",ces.removeCpEmp(empno)?"성공":"실패");
		model.addAttribute("empno",empno);
		
		return "emp/removeResult";
	}//removeEmp
	
	
}//class
