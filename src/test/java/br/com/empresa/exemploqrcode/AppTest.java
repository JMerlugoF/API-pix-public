package br.com.empresa.exemploqrcode;

import org.junit.Test;

public class AppTest {

    @Test
    public void AuthTest()
    {
        Auth authProd = new Auth();
    	String access_token;

        access_token = authProd.geraToken();
    	System.out.println("access_token = "+access_token);
    }

    @Test
    public void CobrançaTest()
    {
        Auth authProd = new Auth();
    	String access_token;

        access_token = authProd.geraToken();
    	System.out.println("access_token = "+access_token);

        Cob cobranca = new Cob();
    	String resultCob="";
    	int idCob=0;

        resultCob = cobranca.doCob(access_token);
    	idCob = cobranca.getIdCob(resultCob);
    	System.out.println("idCobranca = "+idCob);
    }

    @Test
    public void GerarQrTest()
    {
        Auth authProd = new Auth();
    	String access_token;
        access_token = authProd.geraToken();

        Cob cobranca = new Cob();
    	String resultCob="";
    	int idCob=0;

        Loc loc = new Loc();
    	String resultLoc;
    	String qrCode="";

        resultCob = cobranca.doCob(access_token);
    	idCob = cobranca.getIdCob(resultCob);

        resultLoc = loc.genQrCode(idCob, access_token);
    	qrCode = loc.getQrCode(resultLoc);
    	System.out.println("qrCode = "+qrCode);
    }

    @Test
    public void QrImageTest()
    {
        Auth authProd = new Auth();
    	String access_token;
        access_token = authProd.geraToken();

        Cob cobranca = new Cob();
    	String resultCob="";
    	int idCob=0;

        Loc loc = new Loc();
    	String resultLoc;
    	String image="";
    	String imageName;

        resultCob = cobranca.doCob(access_token);
    	idCob = cobranca.getIdCob(resultCob);

        resultLoc = loc.genQrCode(idCob, access_token);

        image = loc.getImage(resultLoc);
    	System.out.println("image = "+image);
    	imageName=loc.saveImage(image);
    }

    @Test
    public void QrImageShowTest()
    {
        Auth authProd = new Auth();
    	String access_token;
        access_token = authProd.geraToken();

        Cob cobranca = new Cob();
    	String resultCob="";
    	int idCob=0;

        Loc loc = new Loc();
    	String resultLoc;
    	String image="";
    	String imageName;

        resultCob = cobranca.doCob(access_token);
    	idCob = cobranca.getIdCob(resultCob);

        resultLoc = loc.genQrCode(idCob, access_token);

        image = loc.getImage(resultLoc);
    	imageName=loc.saveImage(image);
    	loc.showImage(imageName);
    }

    @Test
    public void OpSemAuth(){
        Auth authProd = new Auth();
    	String access_token;
    	
    	Cob cobranca = new Cob();
    	String resultCob="";
    	int idCob=0;
        
    	Loc loc = new Loc();
    	String resultLoc;
    	String qrCode="";
    	String image="";
    	String imageName;

    	access_token = authProd.geraToken();

        access_token += "fa123d1ds";

    	resultCob = cobranca.doCob(access_token);
    	idCob = cobranca.getIdCob(resultCob);
    	
    	resultLoc = loc.genQrCode(idCob, access_token);
    	qrCode = loc.getQrCode(resultLoc);
    	
    	image = loc.getImage(resultLoc);
    	imageName=loc.saveImage(image);
    	loc.showImage(imageName);
    }

    @Test
    public void QrImageShowFailTest()
    {
        Auth authProd = new Auth();
    	String access_token;
        access_token = authProd.geraToken();

        Cob cobranca = new Cob();
    	String resultCob="";
    	int idCob=0;

        Loc loc = new Loc();
    	String resultLoc;
    	String image="";
    	String imageName;

        resultCob = cobranca.doCob(access_token);
    	idCob = cobranca.getIdCob(resultCob);

        resultLoc = loc.genQrCode(idCob, access_token);

        image = loc.getImage(resultLoc);
    	imageName=loc.saveImage(image);
    	loc.showImage("test"+imageName);
    }

    @Test
    public void GerarQrFailTest()
    {
        Auth authProd = new Auth();
    	String access_token;
        access_token = authProd.geraToken();

        Cob cobranca = new Cob();
    	String resultCob="";
    	int idCob=0;

        Loc loc = new Loc();
    	String resultLoc;

        resultCob = cobranca.doCob(access_token);
    	idCob = cobranca.getIdCob(resultCob)+2;

        resultLoc = loc.genQrCode(idCob, access_token);
    }

}
