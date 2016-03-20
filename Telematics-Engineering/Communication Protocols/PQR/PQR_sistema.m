# makefile for System: PQR_sistema

sctAUTOCFGDEP =
sctCOMPFLAGS = -DXUSE_GENERIC_FUNC

include $(sctdir)/makeoptions

IFC_FILENAME = /home/sdl/PQR/PQR_sistema.ifc

default: PQR_sistema$(sctEXTENSION)

PQR_sistema$(sctEXTENSION): \
  PQR_sistema$(sctOEXTENSION) \
  $(sctLINKKERNELDEP)
	$(sctLD)  PQR_sistema$(sctOEXTENSION) $(sctLINKKERNEL)  $(sctLDFLAGS) -o PQR_sistema$(sctEXTENSION)

PQR_sistema$(sctOEXTENSION): \
  PQR_sistema.c
	$(sctCC) $(sctCPPFLAGS) $(sctCCFLAGS) $(sctIFDEF) PQR_sistema.c -o PQR_sistema$(sctOEXTENSION)

clean: clean_gen_objs clean_kernel_objs

clean_gen_objs:
	$(sctRM) \
  PQR_sistema$(sctOEXTENSION) \
  PQR_sistema$(sctEXTENSION)
